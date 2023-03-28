package com.hyun.coin_monitoring_project.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hyun.coin_monitoring_project.R
import com.hyun.coin_monitoring_project.dataModel.CurrentPriceResult

class SelectRVAdapter(val context: Context, val coinPriceResult : List<CurrentPriceResult>)
        : RecyclerView.Adapter<SelectRVAdapter.ViewHolder>() {

    val selectedCoinList = ArrayList<String>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coinName : TextView = view.findViewById(R.id.coinName)
        val coinPriceUpDown : TextView = view.findViewById(R.id.coinPriceUpDown)
        val coinPriceUpDownResult: TextView = view.findViewById(R.id.coinPriceUpDownResult)
        val likeImage : ImageView = view.findViewById(R.id.likeBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinName.text = coinPriceResult[position].coinName

        val fluctate_24H = coinPriceResult[position].coinInfo.fluctate_24H
        val fluctate_rate_24H = coinPriceResult[position].coinInfo.fluctate_rate_24H

        if (fluctate_24H.contains("-")) {
            holder.coinPriceUpDown.text = "하락입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDown.text = "상승입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }

        if (fluctate_rate_24H.contains("-")) {
            holder.coinPriceUpDownResult.text = "↓" + coinPriceResult[position].coinInfo.fluctate_rate_24H
            holder.coinPriceUpDownResult.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDownResult.text = "↑" + coinPriceResult[position].coinInfo.fluctate_rate_24H
            holder.coinPriceUpDownResult.setTextColor(Color.parseColor("#ed2e11"))
        }

        val likeImage = holder.likeImage
        val currentCoin = coinPriceResult[position].coinName

        if (selectedCoinList.contains(currentCoin)) {
            likeImage.setImageResource(R.drawable.like_red)
        } else {
            likeImage.setImageResource(R.drawable.like_grey)
        }

        likeImage.setOnClickListener {

            if (selectedCoinList.contains(currentCoin)) {
                // 포함하면
                selectedCoinList.remove(currentCoin)
                likeImage.setImageResource(R.drawable.like_grey)
            } else {
                // 포함하지 않으면
                selectedCoinList.add(currentCoin)
                likeImage.setImageResource(R.drawable.like_red)
            }
        }
    }

    override fun getItemCount(): Int {
        return coinPriceResult.size
    }
}