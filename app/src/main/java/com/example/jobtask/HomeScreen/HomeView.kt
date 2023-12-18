package com.example.jobtask.HomeScreen

import com.example.jobtask.ModelClass.EmployeeClass

interface HomeView {
    fun showProgress()
    fun dismissProgress()
    fun showData(employeeClass: EmployeeClass)
    fun showError(error:String)
}