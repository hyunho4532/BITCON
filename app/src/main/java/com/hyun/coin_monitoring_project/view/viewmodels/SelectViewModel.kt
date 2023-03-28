package com.hyun.coin_monitoring_project.view.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hyun.coin_monitoring_project.dataModel.CurrentPrice
import com.hyun.coin_monitoring_project.dataModel.CurrentPriceResult
import com.hyun.coin_monitoring_project.network.model.CurrentPriceList
import com.hyun.coin_monitoring_project.repository.NetWorkRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

// 로직 처리 작성
// 액티비티에서 로직 처리한다.
class SelectViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    private lateinit var currentPriceResultList: ArrayList<CurrentPriceResult>

    // 데이터 변화를 관찰하는 LiveData
    private val _currentPriceResult = MutableLiveData<List<CurrentPriceResult>>()
    val currentPriceResult : LiveData<List<CurrentPriceResult>>
        get() = _currentPriceResult

    fun getCurrentCoinList() = viewModelScope.launch {

        val result = netWorkRepository.getCurrentCoinList()

        currentPriceResultList = ArrayList()

        for (coin in result.data) {

            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(result.data.get(coin.key))
                val gsonFromJson = gson.fromJson(gsonToJson, CurrentPrice::class.java)

                val currentPriceResult = CurrentPriceResult(coin.key, gsonFromJson)

                currentPriceResultList.add(currentPriceResult)

            } catch (e : Exception) {
                Timber.d(e.toString())
            }
        }

        _currentPriceResult.value = currentPriceResultList
    }
}