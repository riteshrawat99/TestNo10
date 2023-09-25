package com.pupup.testno10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class FeeAddFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var feeArray: ArrayList<Data_type_for_fee>
    private lateinit var adapterClass: FeeAdapterClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_fee_add, container, false)
        feeArray = arrayListOf()
        feeArray= arrayListOf(
            Data_type_for_fee(R.drawable.baseline_tag_faces_24,"Ritesh",400)
        )

        adapterClass = FeeAdapterClass(requireActivity(),feeArray)
        listView = view.findViewById(R.id.listView)
        listView.adapter=adapterClass

        val student_name01 : EditText = view.findViewById(R.id.student_name)
        val student_fee01 : EditText = view.findViewById(R.id.student_fee)
        val submit : Button = view.findViewById(R.id.fee_btn)
        submit.setOnClickListener {
//            feeArray.add(Data_type_for_fee(R.drawable.baseline_tag_faces_24,"${student_name01.text}",student_fee01.text.toString().toInt()))
            feeArray.add(Data_type_for_fee(R.drawable.baseline_tag_faces_24,"${student_name01.text}",student_fee01.text.toString().toInt()))
            adapterClass.notifyDataSetChanged()
        }
        val layoutDesign = LayoutInflater.from(context).inflate(R.layout.custom_fee_design,null,false)




         return view
    }


}