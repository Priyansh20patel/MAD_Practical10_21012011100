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
        val fab: FloatingActionButton = findViewById(R.id.flo1)
        fab.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "dchj8v1b6qqdjzbqood1jgpachyfzlw58r540gru")
                    withContext(Dispatchers.Main) {
                        try {
                            if(data != null)
                                runOnUiThread{getPersonDetailsFromJson(data)}
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

    private fun getPersonDetailsFromJson(sJson: String) {
        val personList = ArrayList<Person>()
        try {

            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val personadapter=findViewById<ListView>(R.id.listView)
            personadapter.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }

    }

    fun setArrayToListView(){


        val personlistview=findViewById<ListView>(R.id.listView)
        val Array = arrayListOf<Person>(
            Person("1","Priyansh","","9265605089","Gandhinagar",90.90,909.90),
            Person("2","Vishal","ladavavishal22@gmail.com","9081897151","Rajkot",90.90,909.90),
            Person("3","jay","jay22@gmail.com","9081897152","Mehasana",90.90,909.90),
            Person("4","vivek","vivek@gmail.com","9081897153","Morbi",90.90,909.90),
            Person("5","jvk","jvk@gmail.com","9725240046","surat",90.90,909.90)
        )
        personlistview.adapter=PersonAdapter(this,Array)


    }


}