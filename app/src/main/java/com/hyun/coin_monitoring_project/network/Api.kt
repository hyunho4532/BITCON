package com.hyun.coin_monitoring_project.network

import com.hyun.coin_monitoring_project.network.model.CurrentPriceList
import retrofit2.http.GET

interface Api {

    @GET("public/ticker/ALL_KRW")
    suspend fun getCurrentCoinList() : CurrentPriceList
}