package com.example.jobtask.HomeScreen

import com.example.jobtask.ModelClass.EmployeeClass
import com.example.jobtask.RetofitModel.ApiInterface
import com.example.jobtask.RetofitModel.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val homeView: HomeView) {

    fun getData(){
        homeView.showProgress()
        val apiInterface: ApiInterface = RetrofitClient().getClient()!!.create(ApiInterface::class.java)
        apiInterface.getEmployeeData().enqueue(object : Callback<EmployeeClass>{
            override fun onResponse(call: Call<EmployeeClass>, response: Response<EmployeeClass>) {
                if (response.isSuccessful){
                    homeView.dismissProgress()
                    response.body()?.let { homeView.showData(it) }
                }
            }

            override fun onFailure(call: Call<EmployeeClass>, t: Throwable) {
                homeView.dismissProgress()
                t.localizedMessage?.let { homeView.showError(it) }
            }

        })
    }

}