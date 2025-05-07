package dev.abdullah.cryptocurrencyapp.presentation

sealed class Screen(val route: String) {
    data object CoinListScreen : Screen("coin_list_screen")
    data object CoinDetailsScreen : Screen("coin_detail_screen")
}