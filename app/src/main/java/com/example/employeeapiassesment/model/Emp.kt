package com.example.employeeapiassesment.model

import com.example.employeeapiassesment.model.Data

data class Emp(
    val `data`: List<Data>,
    val message: String,
    val status: String
)