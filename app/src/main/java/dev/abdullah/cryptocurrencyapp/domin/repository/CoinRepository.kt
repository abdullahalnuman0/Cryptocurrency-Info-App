package dev.abdullah.cryptocurrencyapp.domin.repository

import dev.abdullah.cryptocurrencyapp.data.remote.dto.CoinDetailsDto
import dev.abdullah.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}
