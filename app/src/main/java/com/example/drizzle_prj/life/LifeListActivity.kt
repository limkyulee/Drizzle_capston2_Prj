package com.example.drizzle_prj.life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.drizzle_prj.R
import com.example.drizzle_prj.kitchen.KitchenCustomAdapter
import com.example.drizzle_prj.kitchen.kitchenModel
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class LifeListActivity : AppCompatActivity() {
    lateinit var listView_details: ListView
    var arrayList_details:ArrayList<lifeModel> = ArrayList();
    //OkHttpClient creates connection pool between client and server
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_list)

        listView_details = findViewById<ListView>(R.id.listViewLife) as ListView
        run("http://43.201.88.75/lifelist.php")
    }

    fun run(url: String) {
//        progress.visibility = View.VISIBLE
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
//                 progress.visibility = View.GONE
            }
            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body()!!.string()

                //creating json object
                val json_contact: JSONObject = JSONObject(str_response)

                //creating json array
                var jsonarray_info: JSONArray = json_contact.getJSONArray("lifeList")

                var i:Int = 0
                var size:Int = jsonarray_info.length()
                arrayList_details= ArrayList();

                for (i in 0.. size-1) {
                    var json_objectdetail: JSONObject =jsonarray_info.getJSONObject(i)
                    var model: lifeModel = lifeModel()
                    model.price = json_objectdetail.getString("price")
                    model.pdNm=json_objectdetail.getString("pdNm")
                    model.mkNm=json_objectdetail.getString("mkNm")
                    model.pdImg=json_objectdetail.getString("pdImg")
                    arrayList_details.add(model)
                }
                runOnUiThread {
                    //stuff that updates ui
                    val obj_adapter : lifeCustomAdapter
                    obj_adapter = lifeCustomAdapter(applicationContext,arrayList_details)
                    listView_details.adapter = obj_adapter
                }
//                 progress.visibility = View.GONE
            }
        })}}