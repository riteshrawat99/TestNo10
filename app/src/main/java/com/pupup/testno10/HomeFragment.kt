package com.pupup.testno10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        val students = arrayListOf<String>("Saurabh","Vivek","Sonu","Monu") // fill student name
        val myAdapter = ArrayAdapter(requireContext(),R.layout.single_row_design,students) // make adapter
        val list_item: ListView = view.findViewById(R.id.list_item) // get list_view reference
        list_item.adapter = myAdapter
        val add_name : EditText = view.findViewById(R.id.add_name)
        val add_btn : Button = view.findViewById(R.id.add_btn)
        add_btn.setOnClickListener {
            if(!add_name.text.isEmpty()){
                Toast.makeText(requireContext(), "${add_name.text.toString()} is add", Toast.LENGTH_SHORT).show()
                students.add(add_name.text.toString())
                myAdapter.notifyDataSetChanged()
            }
            else{
                add_name.error = "Enter Name"
            }
        }
        list_item.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(requireContext(), "${students[i]} is delete", Toast.LENGTH_SHORT).show()
            students.removeAt(i)
            myAdapter.notifyDataSetChanged()
        }
        return view
    }
}