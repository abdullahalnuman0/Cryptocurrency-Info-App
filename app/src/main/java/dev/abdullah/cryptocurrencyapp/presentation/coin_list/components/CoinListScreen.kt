package dev.abdullah.cryptocurrencyapp.presentation.coin_list.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.abdullah.cryptocurrencyapp.presentation.Screen
import dev.abdullah.cryptocurrencyapp.presentation.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
    onExitApp: () -> Unit
) {
    val state by viewModel.state



    Scaffold(
        topBar = {
            AppTobBar(
                onTextChange = {
                    viewModel.onSearch(it.trim())
                }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background.copy(0.8f))
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.coins) { coin ->
                    CoinListItem(coin = coin) {
                        navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
                    }
                }
            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }


    var isOpenBakPressDialog by remember { mutableStateOf(false) }

    BackHandler {
        isOpenBakPressDialog = true;
    }

    if (isOpenBakPressDialog) {
        OnBackPress(onConfirm = onExitApp, onCancel = { isOpenBakPressDialog = false })
    }

}


@Composable
fun OnBackPress(
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    AlertDialog(
        containerColor = colorScheme.surface,
        onDismissRequest = onCancel,
        title = { Text("Exit App?", color = colorScheme.onSurface) },
        text = { Text("Do you really want to exit?", color = colorScheme.onSurface) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("YES", color = colorScheme.onSurface)
            }
        },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text("NO", color = colorScheme.onSurface)
            }
        }
    )
}