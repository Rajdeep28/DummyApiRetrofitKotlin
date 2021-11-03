package com.example.employeeapiassesment.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeeapiassesment.model.Emp
import com.example.employeeapiassesment.network.RetroInstance
import com.example.employeeapiassesment.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var recyclerListData: MutableLiveData<Emp>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getEmpListObservable() : MutableLiveData<Emp>{
        return recyclerListData
    }

    fun getEmployeeList(){
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getEmployeeList()
        call.enqueue(object : Callback<Emp>{
            override fun onResponse(call: Call<Emp>, response: Response<Emp>) {
                if (response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Emp>, t: Throwable) {
                recyclerListData.postValue(null)
            }

        })
    }

    fun searchEmployee(searchtext: String){
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getEmployeeList()
        call.enqueue(object : Callback<Emp>{
            override fun onResponse(call: Call<Emp>, response: Response<Emp>) {
                if (response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Emp>, t: Throwable) {
                recyclerListData.postValue(null)
            }

        })
    }
}