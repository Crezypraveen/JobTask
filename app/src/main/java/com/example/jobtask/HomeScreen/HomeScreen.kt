package com.example.jobtask.HomeScreen

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobtask.Adapter.RecyclerviewAdapter
import com.example.jobtask.ModelClass.DataClass
import com.example.jobtask.ModelClass.EmployeeClass
import com.example.jobtask.ModelClass.OnClick
import com.example.jobtask.R
import com.example.jobtask.SearchScreen
import com.example.jobtask.SingleUserScreen
import com.example.jobtask.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity(), HomeView,OnClick {

    lateinit var binding: ActivityHomeScreenBinding
    var progressDialog:ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        val homePresenter = HomePresenter(this)
        homePresenter.getData()


        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        binding.searchView.setOnClickListener {
            val intent = Intent(this, SearchScreen::class.java)
            startActivity(intent)
        }

    }

    override fun showProgress() {
        progressDialog?.show()
    }

    override fun dismissProgress() {
        progressDialog?.dismiss()
    }

    override fun showData(employeeClass: EmployeeClass) {

        val adapter = RecyclerviewAdapter(this,this)

        employeeClass.data?.let { adapter.setData(it) }
        binding.recyclerview.adapter = adapter
    }

    override fun showError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun onDataClick(dataClass: DataClass) {
        val intent = Intent(this@HomeScreen, SingleUserScreen::class.java)
        intent.putExtra("name", dataClass.employeeName)
        intent.putExtra("age", dataClass.employeeAge.toString())
        intent.putExtra("salary", dataClass.employeeSalary.toString())
        intent.putExtra("id", dataClass.id.toString())
        startActivity(intent)
    }
}