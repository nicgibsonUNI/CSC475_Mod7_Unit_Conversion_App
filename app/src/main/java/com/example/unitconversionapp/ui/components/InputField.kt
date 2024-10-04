package com.example.unitconversionapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InputField(inputValue: String, onValueChange: (String) -> Unit, inputError: Boolean) {
    Column {
        OutlinedTextField(
            value = inputValue,
            onValueChange = onValueChange,
            label = { Text("Enter value") },
            isError = inputError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        if (inputError) {
            Text(
                text = "Please enter a valid number",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

