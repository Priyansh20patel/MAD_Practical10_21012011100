package com.priyanshpatel.mad_practical10_21012011100

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class PersonAdapter( context: Context,val personArray:ArrayList<Person>):ArrayAdapter<Person>(context,0,personArray)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=LayoutInflater.from(context).inflate(R.layout.person_item,parent,false)
        val contact=getItem(position)

        view.findViewById<TextView>(R.id.person_name).text = contact?.name
        view.findViewById<TextView>(R.id.personnumber).text = contact?.phoneNo
        view.findViewById<TextView>(R.id.personemail).text = contact?.emailId
        view.findViewById<TextView>(R.id.personaddress).text = contact?.address
        val button1: Button = view.findViewById(R.id.locationBtn)
        button1.setOnClickListener {
            // Start the MapsActivity when button1 is clicked
            val intent = Intent(context, MapsActivity::class.java)
            context.startActivity(intent)
        }

        return view
    }
}