package dev.abdullah.cryptocurrencyapp.domin.use_case.get_coin

import dev.abdullah.cryptocurrencyapp.common.Resource
import dev.abdullah.cryptocurrencyapp.data.remote.dto.toCoin
import dev.abdullah.cryptocurrencyapp.data.remote.dto.toCoinDetail
import dev.abdullah.cryptocurrencyapp.domin.model.Coin
import dev.abdullah.cryptocurrencyapp.domin.model.CoinDetail
import dev.abdullah.cryptocurrencyapp.domin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {

            emit(Resource.Loading())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred !!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection !!"))

        }
    }
}