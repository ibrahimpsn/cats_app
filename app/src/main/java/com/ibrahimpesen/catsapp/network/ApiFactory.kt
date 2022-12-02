package com.ibrahimpesen.catsapp.network

import com.ibrahimpesen.catsapp.model.CatsItem
import io.reactivex.Single


import retrofit2.http.GET

interface ApiFactory {

    //https://api.thecatapi.com/v1/breeds?limit=20

    @GET("v1/breeds")
    fun getCats(): Single<List<CatsItem>>
}