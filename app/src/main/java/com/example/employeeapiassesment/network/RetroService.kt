package com.example.employeeapiassesment.network

import com.example.employeeapiassesment.model.Emp
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("api/v1/employees")
    fun getEmployeeList(): Call<Emp>

}