package com.example.jobtask.RetofitModel

import com.example.jobtask.ModelClass.EmployeeClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("employees")
    fun getEmployeeData(): Call<EmployeeClass>
}