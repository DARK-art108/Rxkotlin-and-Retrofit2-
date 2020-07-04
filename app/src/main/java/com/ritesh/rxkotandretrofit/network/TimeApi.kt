package com.ritesh.rxkotandretrofit.network

import com.ritesh.rxkotandretrofit.modals.Time
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface TimeApi {

    @GET("api/timezone/Europe/London")
    fun getTime() :Observable<Time>

}