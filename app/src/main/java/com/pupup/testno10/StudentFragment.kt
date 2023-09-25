package com.pupup.testno10

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class StudentFragment : Fragment(){
    private lateinit var student_add : ArrayList<Student_dialog_data>
    private lateinit var student_adapter : Student_adapter
    private lateinit var listView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_student, container, false)
        val add_student : Button = view.findViewById(R.id.add_some_student)

        student_add = arrayListOf()
        student_add = arrayListOf(
            Student_dialog_data(R.drawable.baseline_tag_faces_24,"Ritesh","rk3818487@gmail.com","ritsh@gmail13",88687979)
        )
        student_adapter= Student_adapter(requireContext(),student_add)
        listView = view.findViewById(R.id.list_item1)
        listView.adapter = student_adapter


        listView.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->
            student_add.removeAt(i)
            student_adapter.notifyDataSetChanged()
        }

        // for dialog box
        add_student.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.dialog_layout,null)
            val ok_btn : Button = layout.findViewById(R.id.ok_btn)
            val get_name : EditText = layout.findViewById(R.id.student_name)
            val get_phone : EditText = layout.findViewById(R.id.student_phone)
            val get_email : EditText = layout.findViewById(R.id.student_email)
            val get_pass : EditText = layout.findViewById(R.id.student_pass)

            val alertDialog = AlertDialog.Builder(requireContext())

            alertDialog.setView(layout)
            val dialog = alertDialog.create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCanceledOnTouchOutside(false)

            dialog.show()
            dialog.window?.setLayout(900,1200)

            ok_btn.setOnClickListener {

                if (get_name.text.isEmpty()){
                    get_name.error = "Enter your name"
                }
                else if(get_email.text.isEmpty()){
                    get_email.error= "Enter your email"
                }
                else if (get_phone.text.length<=10){
                    get_phone.error = "Enter your phone Number"
                }
                else{
                    student_add.add(Student_dialog_data(R.drawable.baseline_tag_faces_24,"${get_name.text}","${get_email.text}","${get_pass.text}",get_phone.text.toString().toLong()))
                    student_adapter.notifyDataSetInvalidated()
                    Toast.makeText(context, "one student added here", Toast.LENGTH_SHORT).show()
                    dialog.onBackPressed()
                }
            }

        }

        return view
    }
}