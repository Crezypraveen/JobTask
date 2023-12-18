package com.example.jobtask

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobtask.Adapter.RecyclerviewAdapter
import com.example.jobtask.HomeScreen.HomePresenter
import com.example.jobtask.HomeScreen.HomeView
import com.example.jobtask.ModelClass.DataClass
import com.example.jobtask.ModelClass.EmployeeClass
import com.example.jobtask.ModelClass.OnClick
import com.example.jobtask.databinding.ActivitySearchScreenBinding

class SearchScreen : AppCompatActivity(), OnClick, HomeView {

    lateinit var binding:ActivitySearchScreenBinding
    var list: MutableList<DataClass> = ArrayList<DataClass>()
    var searchAdapter: RecyclerviewAdapter? = null
    var progressDialog:ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        val homePresenter = HomePresenter(this)
        homePresenter.getData()


        binding.searchView.requestFocus()

        binding.listView.layoutManager = LinearLayoutManager(applicationContext)
        searchAdapter = RecyclerviewAdapter(applicationContext, this)
        binding.listView.adapter = searchAdapter

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                searchAdapter!!.setData(list)
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() == "") {
                    binding.listView.visibility = View.INVISIBLE
                } else {
                    binding.listView.visibility = View.VISIBLE
                    searchAdapter!!.filter(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })


    }

    override fun onDataClick(dataClass: DataClass) {

        val intent = Intent(this@SearchScreen, SingleUserScreen::class.java)
        intent.putExtra("name", dataClass.employeeName)
        intent.putExtra("age", dataClass.employeeAge.toString())
        intent.putExtra("salary", dataClass.employeeSalary.toString())
        intent.putExtra("id", dataClass.id.toString())
        startActivity(intent)

    }

    override fun showProgress() {
        progressDialog?.show()
    }

    override fun dismissProgress() {
        progressDialog?.dismiss()
    }

    override fun showData(employeeClass: EmployeeClass) {
        list = employeeClass.data!!
    }

    override fun showError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}