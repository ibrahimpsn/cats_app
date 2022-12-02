package com.ibrahimpesen.catsapp.service

import com.ibrahimpesen.catsapp.model.CatsItem
import com.ibrahimpesen.catsapp.network.ApiFactory
import io.reactivex.Single


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val BASE_URL ="https://api.thecatapi.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiFactory::class.java)

    fun getData(): Single<List<CatsItem>> {
        return api.getCats()
    }
}