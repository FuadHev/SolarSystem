package com.info.solarsystem.data.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="https://planets-info-by-newbapi.p.rapidapi.com/api/v1/"
        fun getPlanetsInterface():GetPlanetsInterface{
            return RetrofitClient.getClient(BASE_URL)
                .create(GetPlanetsInterface::class.java)


        }

    }
}