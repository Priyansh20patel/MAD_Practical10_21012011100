package com.priyanshpatel.mad_practical10_21012011100

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class PersonAdapter(private val context:Context, private val personArray: ArrayList<Person>):ArrayAdapter<Person>(context,0,personArray){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(context).inflate(R.layout.person_item,parent,false)

        view.findViewById<TextView>(R.id.tv_layout_1).text = personArray[position].name
        view.findViewById<TextView>(R.id.tv_layout_2).text = personArray[position].phoneNo
        view.findViewById<TextView>(R.id.tv_layout_3).text = personArray[position].emailId
        view.findViewById<TextView>(R.id.tv_layout_4).text= personArray[position].address
        view.findViewById<MaterialButton>(R.id.MaterialButton2)
        Intent(context,MapsActivity::class.java).putExtra("object",personArray[position]).apply { context.startActivity(this) }
        return view
    }

}