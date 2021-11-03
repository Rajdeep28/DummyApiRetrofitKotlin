package com.example.employeeapiassesment.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
//https://dummy.restapiexample.com/api/v1/employees

    companion object{
        val base_url = "https://dummy.restapiexample.com/"

        fun getRetrofitInstance(): Retrofit{

            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(base_url)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}