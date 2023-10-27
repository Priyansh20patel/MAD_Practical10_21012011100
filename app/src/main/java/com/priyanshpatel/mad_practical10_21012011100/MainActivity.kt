package com.priyanshpatel.mad_practical10_21012011100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.action_btn)
        fab.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1"
                    )
                    withContext(Dispatchers.Main) {
                        try {
                            if (data != null)
                                runOnUiThread { getPersonDetailsFromJson(data) }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }


    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val personListView = findViewById<ListView>(R.id.listView)
            personListView.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }


    fun setArraytoListView() {
        val personListView = findViewById<ListView>(R.id.listView)
        val Array = arrayListOf<Person>(
            Person("nljnl", "nlnk", "nklnkl", "nklnkl", "nllkl", 90.90, 909.90),
            Person("nljnl", "nlnk", "nklnkl", "nklnkl", "nllkl", 90.90, 909.90),
            Person("nljnl", "nlnk", "nklnkl", "nklnkl", "nllkl", 90.90, 909.90),
            Person("nljnl", "nlnk", "nklnkl", "nklnkl", "nllkl", 90.90, 909.90),
            Person("nljnl", "nlnk", "nklnkl", "nklnkl", "nllkl", 90.90, 909.90)

        )
        personListView.adapter = PersonAdapter(this, arrayListOf())
    }

}