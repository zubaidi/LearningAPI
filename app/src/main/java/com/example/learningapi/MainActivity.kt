package com.example.learningapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Tag
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    private lateinit var dataAdapter: DataItemAdapter
    val list = ArrayList<DataAPI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataFromApi()

        /*
        val apiHelper = APIHelper.getInstance()

        GlobalScope.launch {

            val getData = apiHelper.getPost()
            if ( getData != null ) {
                Log.d("hasil : ", getData.body().toString())
            }

            withContext(Dispatchers.Main) {
                statusRespons.text = "Status Respon : ${ getData.code().toString() }"
                //statusBody.text = "ID : ${getData.body()?.id} \n Judul: ${getData.body()?.judul} \n Isi: ${getData.body()?.text} \n"
            }

        }
         */

    }

    private fun getDataFromApi() {

        listItem.layoutManager = LinearLayoutManager(this)

        APIHelper.api.getPost().enqueue(object : Callback<ArrayList<DataAPI>> {
            override fun onResponse(call: Call<ArrayList<DataAPI>>, response: Response<ArrayList<DataAPI>>) {
                if (response.isSuccessful) {
                    supportActionBar!!.title = "Learning API Status ${response.code().toString()}"
                    response.body()?.let {
                        list.addAll(it)
                    }
                    dataAdapter = DataItemAdapter(list)
                    listItem.adapter = dataAdapter
                    Log.d("hasil: ", response.body().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<DataAPI>>, t: Throwable) {
                Log.d("hasil : ", t.toString())
            }

        })

    }
}