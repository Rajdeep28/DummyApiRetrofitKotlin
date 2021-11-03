package com.example.employeeapiassesment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeeapiassesment.view.viewmodel.MainActivityViewModel
import com.example.employeeapiassesment.R
import com.example.employeeapiassesment.view.adapter.RecyclerViewAdapter
import com.example.employeeapiassesment.model.Data
import com.example.employeeapiassesment.model.Emp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModels()
        //searchUser()
    }

    private fun initRecyclerView(){
        rvEmpList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            recyclerViewAdapter.setOnclickListener(object :
                RecyclerViewAdapter.onItemClickListener {
                override fun onIteClick(position: Int) {
                    Toast.makeText(this@MainActivity,"You are click on the item no: $position",Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    fun initViewModels(){
       viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getEmpListObservable().observe(this, Observer<Emp> {
            if (it == null){
                Toast.makeText(this@MainActivity,"no result found....",Toast.LENGTH_LONG).show()
            }
            else{
               // recyclerViewAdapter.empList = it.data.toMutableList()
                   recyclerViewAdapter.empList = it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        //tvView.text = viewModel.getEmployeeList().toString()
        viewModel.getEmployeeList()

    }
}