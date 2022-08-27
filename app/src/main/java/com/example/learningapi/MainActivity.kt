package com.example.learningapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var dataAdapter: DataItemAdapter
    val list = ArrayList<GetDataAPI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataFromApi()

        createPost()

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

    private fun createPost() {
        APIHelper.api.createPost(
            29, "Belajar Retrofit", "Zubaidi Belajar Retrofit"
        ).enqueue(object : Callback<PostDataAPI> {
            override fun onResponse(call: Call<PostDataAPI>, response: Response<PostDataAPI>) {
                supportActionBar!!.title = "Learning API Status ${response.code()}"
                Log.d("hasil : \n", "uid: ${ response.body()?.userID } \n " +
                        "id: ${ response.body()?.id } \n" +
                        "judul: ${ response.body()?.judul } \n" +
                        "text: ${ response.body()?.text }  ")
            }

            override fun onFailure(call: Call<PostDataAPI>, t: Throwable) {
                Log.d("hasil : ", t.toString())
            }

        })
    }

    private fun getDataFromApi() {

        listItem.layoutManager = LinearLayoutManager(this)

        APIHelper.api.getPost().enqueue(object : Callback<ArrayList<GetDataAPI>> {
            override fun onResponse(call: Call<ArrayList<GetDataAPI>>, response: Response<ArrayList<GetDataAPI>>) {
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

            override fun onFailure(call: Call<ArrayList<GetDataAPI>>, t: Throwable) {
                Log.d("hasil : ", t.toString())
            }

        })

    }
}