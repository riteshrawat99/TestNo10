package com.pupup.testno10

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Student_adapter(
    val context: Context,
    val studentData: ArrayList<Student_dialog_data>
):BaseAdapter() {
    override fun getCount(): Int {
       return studentData.size
    }

    override fun getItem(p0: Int): Any {
       return studentData[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder", "MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutDesign = LayoutInflater.from(context).inflate(R.layout.multi_row_design_add_student,p2,false)
        val profile : ImageView = layoutDesign.findViewById(R.id.profile)
        val get_name1 : TextView = layoutDesign.findViewById(R.id.get_name_sec)
        val get_email : TextView = layoutDesign.findViewById(R.id.get_email)
        val get_phone : TextView = layoutDesign.findViewById(R.id.get_phone)

        profile.setImageResource(R.drawable.baseline_tag_faces_24)
        get_name1.text=studentData[p0].name
        get_email.text=studentData[p0].email
        get_phone.text=studentData[p0].phone.toString()

        return layoutDesign
    }

}