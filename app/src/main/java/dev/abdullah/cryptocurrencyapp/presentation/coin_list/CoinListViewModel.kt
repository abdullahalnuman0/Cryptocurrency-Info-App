package dev.abdullah.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abdullah.cryptocurrencyapp.common.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import dev.abdullah.cryptocurrencyapp.domin.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getConinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _main = mutableStateOf(CoinListState())
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    fun onSearch(key: String?) {


        if (key.isNullOrEmpty()) {
            _state.value = _main.value;
        } else if (_main.value.coins.isNotEmpty()) {

            val filteredCoins = _main.value.coins.filter {
                it.name.contains(key, ignoreCase = true)
                        || it.id.contains(key, ignoreCase = true)
                        || it.symbol.contains(key, ignoreCase = true)
            }
            _state.value = _main.value.copy(coins = filteredCoins)
        }
    }

    private fun getCoins() {
        getConinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                    _main.value = _state.value;
                }

                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occurred !!"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}