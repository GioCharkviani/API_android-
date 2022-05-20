package com.example.api_rickandmorty.api

import com.example.api_rickandmorty.api.dto.ReqResData
import com.example.api_rickandmorty.api.dto.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService {
    @GET("character")
    fun getCharacter(@Query("pages")page: Int): Call<ReqResData<List<Character>>>
    @GET("character/{characterId}")
    fun getCharacter(@Query("characterId")id: Long): Call<ReqResData<Character>>
}