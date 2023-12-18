package com.example.jobtask.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtask.ModelClass.DataClass
import com.example.jobtask.ModelClass.OnClick
import com.example.jobtask.R
import java.util.Locale

class RecyclerviewAdapter(context: Context,var onClick: OnClick): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    var list: MutableList<DataClass> = ArrayList<DataClass>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_design_layout, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {

        val data = list[position]

        holder.name.text = data.employeeName
        holder.salary.text = data.employeeSalary.toString()
        holder.age.text = data.employeeAge.toString()
        holder.id.text = data.id.toString()


        holder.itemView.setOnClickListener {
            onClick.onDataClick(list[position])
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.findViewById(R.id.emp_name)
        val salary: TextView = itemView.findViewById(R.id.emp_salary)
        val age: TextView = itemView.findViewById(R.id.emp_age)
        val id: TextView = itemView.findViewById(R.id.emp_id)
    }

    fun setData(list: MutableList<DataClass>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun filter(text: String) {
        val temp: MutableList<DataClass> = ArrayList<DataClass>()
        for (d in list) {
            if (d.employeeName?.toLowerCase(Locale.ROOT)!!.contains(text.lowercase(Locale.getDefault()))) {
                temp.add(d)
            }
        }
        setData(temp)
    }

}