package com.example.unitconversionapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitTypeDropdown(
    selectedType: String,
    onTypeSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val conversionTypes = listOf("Temperature", "Length", "Weight")

    // Use ExposedDropdownMenuBox for dropdown behavior
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded } // Toggle expanded state when clicked
    ) {
        OutlinedTextField(
            value = selectedType,
            onValueChange = { }, // Do nothing, dropdown controls this
            readOnly = true, // Make the field read-only
            label = { Text("Select Conversion Type") },
            trailingIcon = { // Use the arrow dropdown icon
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor() // Required for ExposedDropdownMenuBox to position the dropdown
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        // Exposed Dropdown Menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            conversionTypes.forEach { type ->
                DropdownMenuItem(
                    text = { Text(text = type) },
                    onClick = {
                        onTypeSelected(type)
                        expanded = false // Close the dropdown when an item is selected
                    }
                )
            }
        }
    }
}

