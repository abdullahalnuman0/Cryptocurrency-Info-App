package dev.abdullah.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.abdullah.cryptocurrencyapp.common.Constants
import dev.abdullah.cryptocurrencyapp.presentation.coin_details.components.CoinDetailScreen
import dev.abdullah.cryptocurrencyapp.presentation.coin_list.components.CoinListScreen
import dev.abdullah.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptocurrencyAppTheme {
                Box(modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(Screen.CoinListScreen.route) {
                            CoinListScreen(
                                navController = navController,
                                onExitApp = {finish()}
                            )
                        }

                        composable(
                            route = "${Screen.CoinDetailsScreen.route}/{${Constants.PARAM_COIN_ID}}",
                        ) {
                            CoinDetailScreen()
                        }


                    }

                }
            }
        }
    }
}
