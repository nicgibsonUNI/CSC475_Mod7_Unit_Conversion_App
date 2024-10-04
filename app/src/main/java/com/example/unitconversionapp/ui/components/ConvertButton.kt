package com.example.unitconversionapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConvertButton(onConvertClick: () -> Unit) {
    Button(
        onClick = onConvertClick,
        modifier = Modifier
            .fillMaxWidth(0.8f) // Make the button take 80% of the width
            .padding(top = 16.dp)
    ) {
        Text("Convert")
    }
}

