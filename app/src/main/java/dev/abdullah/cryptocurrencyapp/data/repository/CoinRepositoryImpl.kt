package dev.abdullah.cryptocurrencyapp.data.repository

import dev.abdullah.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dev.abdullah.cryptocurrencyapp.data.remote.dto.CoinDetailsDto
import dev.abdullah.cryptocurrencyapp.data.remote.dto.CoinDto
import dev.abdullah.cryptocurrencyapp.domin.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }

}