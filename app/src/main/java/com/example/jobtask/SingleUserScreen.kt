package com.example.jobtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jobtask.databinding.ActivitySingleUserScreenBinding

class SingleUserScreen : AppCompatActivity() {

    lateinit var binding: ActivitySingleUserScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingleUserScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val salary = intent.getStringExtra("salary")
        val id = intent.getStringExtra("id")

        binding.empName.text = name
        binding.empAge.text = age
        binding.empSalary.text = salary
        binding.empId.text = id

        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}