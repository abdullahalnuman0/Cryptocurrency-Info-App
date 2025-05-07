package dev.abdullah.cryptocurrencyapp.domin.model

import com.google.gson.annotations.SerializedName
import dev.abdullah.cryptocurrencyapp.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

