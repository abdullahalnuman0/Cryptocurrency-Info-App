package dev.abdullah.cryptocurrencyapp.presentation.coin_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun CoinTag(
    modifier: Modifier = Modifier,
    tag: String
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ){
       Text(
           text = tag,
           color = MaterialTheme.colorScheme.primary,
           textAlign = TextAlign.Center,
           style = MaterialTheme.typography.bodyMedium
       )
    }
}


