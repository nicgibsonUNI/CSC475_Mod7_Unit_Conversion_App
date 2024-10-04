package com.example.unitconversionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconversionapp.helpers.convertUnits
import com.example.unitconversionapp.ui.components.InputField
import com.example.unitconversionapp.ui.components.ResultDisplay
import com.example.unitconversionapp.ui.components.UnitDropdown
import com.example.unitconversionapp.ui.components.ConvertButton
import com.example.unitconversionapp.ui.theme.UnitConversionAppTheme
import com.example.unitconversionapp.ui.components.UnitTypeDropdown
import androidx.compose.material3.Text


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConversionAppTheme {
                UnitConversionScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConversionScreen(modifier: Modifier = Modifier) {
    // Define the state variables inside the composable
    var inputValue by remember { mutableStateOf("") }
    var inputError by remember { mutableStateOf(false) }
    var conversionType by remember { mutableStateOf("Temperature") }
    var selectedUnit by remember { mutableStateOf("Celsius to Fahrenheit") }
    var result by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Unit Conversion App",
                        style = MaterialTheme.typography.titleLarge // Style the title
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors( // Set background color
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary // Text color
                )
            )
        },
        content = { padding ->
            // Apply padding from Scaffold content
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Input field for value to convert
                InputField(
                    inputValue = inputValue,
                    onValueChange = {
                        inputValue = it
                        inputError = it.isEmpty() || it.toDoubleOrNull() == null
                    },
                    inputError = inputError
                )

                // Dropdown for conversion type
                UnitTypeDropdown(
                    selectedType = conversionType,
                    onTypeSelected = {
                        conversionType = it
                        selectedUnit = when (it) {
                            "Temperature" -> "Celsius to Fahrenheit"
                            "Length" -> "Meters to Kilometers"
                            "Weight" -> "Kilograms to Pounds"
                            else -> ""
                        }
                    }
                )

                // Dropdown for unit selection
                UnitDropdown(
                    conversionType = conversionType,
                    selectedUnit = selectedUnit,
                    onUnitSelected = { selectedUnit = it }
                )

                // Convert Button
                ConvertButton(onConvertClick = {
                    if (!inputError) {
                        result = convertUnits(inputValue, selectedUnit, conversionType)
                    }
                })

                // Display the result
                ResultDisplay(result = result)
            }
        }
    )
}




    @Preview(showBackground = true)
@Composable
fun UnitConversionPreview() {
    UnitConversionAppTheme {
        UnitConversionScreen()
    }
}
