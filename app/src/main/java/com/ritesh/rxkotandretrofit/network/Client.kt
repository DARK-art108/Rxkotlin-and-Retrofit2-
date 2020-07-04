package com.ritesh.rxkotandretrofit.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//http://worldtimeapi.org/api/timezone/Europe/London.txt
object Client {
   private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("http://worldtimeapi.org")
        .build()

   private val timeApi = retrofit.create(TimeApi::class.java)

    val time = timeApi.getTime()





}