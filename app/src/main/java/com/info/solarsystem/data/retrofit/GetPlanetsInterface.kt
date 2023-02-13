package com.info.solarsystem.data.retrofit

import com.info.solarsystem.data.entity.BasicDetail
import com.info.solarsystem.data.entity.Planets
import com.info.solarsystem.data.entity.PlanetsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetPlanetsInterface {
    @Headers("X-RapidAPI-Key:86347cf50amshad9291561d5023bp154c19jsn872ca464bf8c",
             "X-RapidAPI-Host:planets-info-by-newbapi.p.rapidapi.com")
    @GET("planet/list")
    fun getPlanets(): Call<Planets>




}