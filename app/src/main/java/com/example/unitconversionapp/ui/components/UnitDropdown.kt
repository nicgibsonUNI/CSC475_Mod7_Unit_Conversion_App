package com.example.unitconversionapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitDropdown(
    conversionType: String,
    selectedUnit: String,
    onUnitSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    // Define available units based on the conversion type
    val units = when (conversionType) {
        "Temperature" -> listOf("Celsius to Fahrenheit", "Fahrenheit to Celsius")
        "Length" -> listOf("Meters to Kilometers", "Kilometers to Meters")
        "Weight" -> listOf("Kilograms to Pounds", "Pounds to Kilograms")
        else -> listOf()
    }

    // Use ExposedDropdownMenuBox for dropdown behavior
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded } // Toggle dropdown state
    ) {
        OutlinedTextField(
            value = selectedUnit,
            onValueChange = { }, // Do nothing, the dropdown controls this
            readOnly = true, // Make the field read-only
            label = { Text("Select Unit") },
            trailingIcon = { // Use the dropdown arrow icon
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
            units.forEach { unit ->
                DropdownMenuItem(
                    text = { Text(text = unit) },
                    onClick = {
                        onUnitSelected(unit)
                        expanded = false // Close the dropdown after selection
                    }
                )
            }
        }
    }
}

