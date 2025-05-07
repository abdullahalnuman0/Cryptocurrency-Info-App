package dev.abdullah.cryptocurrencyapp.presentation.coin_details

import dev.abdullah.cryptocurrencyapp.domin.model.Coin
import dev.abdullah.cryptocurrencyapp.domin.model.CoinDetail

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
