package com.hyun.coin_monitoring_project.repository

import com.hyun.coin_monitoring_project.network.Api
import com.hyun.coin_monitoring_project.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList();
}