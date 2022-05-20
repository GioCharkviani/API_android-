package com.example.api_rickandmorty.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.api_rickandmorty.R
import com.example.api_rickandmorty.adapters.CharacterRecyclerAdapter.Companion.USER_ID
import com.example.api_rickandmorty.api.RestClient
import com.example.api_rickandmorty.api.dto.ReqResData
import com.example.api_rickandmorty.api.dto.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterActivity : AppCompatActivity() {
    private lateinit var nameView: TextView
    private lateinit var yearView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        nameView = findViewById(R.id.textView3)
        yearView = findViewById(R.id.textView4)

        val userId = intent.extras?.getLong(USER_ID, -1)
        if (userId != -1L){
            RestClient.reqResApi.getCharacter(userId!!).enqueue(object : Callback<ReqResData<Character>> {
                override fun onResponse(
                    call: Call<ReqResData<Character>>,
                    response: Response<ReqResData<Character>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.data?.let {
                            nameView.text = it.name
                            yearView.text = it.year.toString()
                        }
                    }
                }

                override fun onFailure(call: Call<ReqResData<Character>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}