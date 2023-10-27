package com.priyanshpatel.mad_practical10_21012011100

import android.provider.ContactsContract.CommonDataKinds.Email
import org.json.JSONObject
import java.io.Serializable

class Person(var id:String,
             var name:String,
             var emailId:String,
             var phoneNo:String,
             var  address:String,
             var latitude:Double,
             var longitude:Double):Serializable{

    constructor(jsonObject: JSONObject):this("","","","","",0.0,0.0) {

        id = jsonObject.getString("Person Name")
        emailId = jsonObject.getString("email")
        phoneNo = jsonObject.getString("phone")
        val profileJson = jsonObject.getJSONObject("profile")
        name = profileJson.getString("name")
        address = profileJson.getString("address")
        val locationJson = profileJson.getJSONObject("location")
        latitude = locationJson.getDouble("lat")
        longitude = locationJson.getDouble("long")
    }
             }
