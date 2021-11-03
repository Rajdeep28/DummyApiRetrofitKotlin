package com.example.employeeapiassesment.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeapiassesment.R
import com.example.employeeapiassesment.model.Data
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var empList = mutableListOf<Data>()

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onIteClick(position: Int)
    }

    fun setOnclickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return MyViewHolder(inflater,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentEmp = empList[position]
        if (currentEmp.id != 0){
            holder.employeeName.text = currentEmp.employee_name
            holder.employeeSalary.text = currentEmp.employee_salary.toString()
            holder.emPloyeeId.text = currentEmp.id.toString()
            holder.employeeAge.text = currentEmp.employee_age.toString()
        }

    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class MyViewHolder(view: View, listener: onItemClickListener): RecyclerView.ViewHolder(view){

        var employeeName = view.employee_name
        var employeeSalary = view.employee_salary
        var emPloyeeId = view.employee_id
        var employeeAge = view.employee_age



        init {
            itemView.setOnClickListener {
                 listener.onIteClick(absoluteAdapterPosition)
            }
        }

    }

}