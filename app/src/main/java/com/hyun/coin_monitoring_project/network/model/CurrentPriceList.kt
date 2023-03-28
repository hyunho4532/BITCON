package com.hyun.coin_monitoring_project.network.model

data class CurrentPriceList (
    val status: String,
    val data: Map<String, Any>
)