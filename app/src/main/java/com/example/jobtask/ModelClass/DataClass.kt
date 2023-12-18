package com.example.jobtask.ModelClass

import com.google.gson.annotations.SerializedName

class DataClass {
    @SerializedName("id")
    var id:Int? = null
    @SerializedName("employee_name")
    var employeeName:String? = null
    @SerializedName("employee_salary")
    var employeeSalary:Int? = null
    @SerializedName("employee_age")
    var employeeAge:Int? = null
    @SerializedName("profile_image")
    var profileImage:String? = null
}