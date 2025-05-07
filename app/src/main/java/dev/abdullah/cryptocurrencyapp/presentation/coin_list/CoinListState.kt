package dev.abdullah.cryptocurrencyapp.presentation.coin_list

import dev.abdullah.cryptocurrencyapp.domin.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
