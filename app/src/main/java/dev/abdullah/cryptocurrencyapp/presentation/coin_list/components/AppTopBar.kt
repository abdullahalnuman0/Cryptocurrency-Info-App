package dev.abdullah.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTobBar(
    onTextChange: (String) -> Unit
) {

    var isSearching by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }


    TopAppBar(
        title = {
            if (isSearching) {

                TextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        onTextChange(it)
                    },
                    placeholder = { Text("Search...", color = Color.White.copy(alpha = 0.6f)) },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.White,
                        focusedSuffixColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                )
            } else {
                Text("Cryptocurrency App", color = Color.White)
            }
        },
        navigationIcon = {
            if (isSearching) {
                IconButton(onClick = {
                    isSearching = false
                    searchText = ""
                    onTextChange("")
                }) {
                    Icon(
                        Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        },
        actions = {
            if (!isSearching) {
                IconButton(onClick = {
                    isSearching = true
                }) {
                    Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                }
            } else {
                IconButton(onClick = {
                    searchText = ""
                    onTextChange("")
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White)
                }
            }
        },
    )

}