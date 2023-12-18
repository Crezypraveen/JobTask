package com.example.jobtask.ModelClass

import com.google.gson.annotations.SerializedName

class EmployeeClass {
    @SerializedName("status")
    var status:String? = null
    @SerializedName("data")
    var data:MutableList<DataClass>? = null
    @SerializedName("message")
    var message:String? = null
}