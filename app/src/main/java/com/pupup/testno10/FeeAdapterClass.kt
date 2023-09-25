package com.pupup.testno10

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FeeAdapterClass(val context: Context, val feeArray: ArrayList<Data_type_for_fee>): BaseAdapter() {

    override fun getCount(): Int {
      return  feeArray.size
    }

    override fun getItem(p0: Int): Any {
        return feeArray[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder", "MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
       val layout = LayoutInflater.from(context).inflate(R.layout.custom_fee_design,p2,false)
        val student_name : TextView = layout.findViewById(R.id.fee_student_name)
        val student_fee : TextView = layout.findViewById(R.id.fee_fee)
        val student_profile : ImageView = layout.findViewById(R.id.fee_profile)


        student_profile.setImageResource(feeArray[p0].s_image)
        student_name.text = feeArray[p0].s_name
        student_fee.text = feeArray[p0].s_feee.toString()

        return layout
    }

}