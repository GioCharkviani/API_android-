package com.example.api_rickandmorty.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_rickandmorty.R
import com.example.api_rickandmorty.adapters.CharacterRecyclerAdapter
import com.example.api_rickandmorty.api.RestClient
import com.example.api_rickandmorty.api.dto.Character
import com.example.api_rickandmorty.api.dto.ReqResData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.initClient()
        RestClient.reqResApi.getCharacter(1).enqueue(object :
            Callback<ReqResData<List<Character>>> {
            override fun onResponse(
                call: Call<ReqResData<List<Character>>>,
                response: Response<ReqResData<List<Character>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.let {
                        recyclerView.adapter = CharacterRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<Character>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}