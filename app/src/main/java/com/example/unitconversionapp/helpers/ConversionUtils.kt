package com.example.unitconversionapp.helpers

fun convertUnits(value: String, selectedUnit: String, conversionType: String): String {
    val input = value.toDoubleOrNull()
    if (input != null) {
        return when (conversionType) {
            "Temperature" -> when (selectedUnit) {
                "Celsius to Fahrenheit" -> ((input * 9 / 5) + 32).toString()
                "Fahrenheit to Celsius" -> ((input - 32) * 5 / 9).toString()
                else -> "Invalid temperature conversion"
            }
            "Length" -> when (selectedUnit) {
                "Meters to Kilometers" -> (input / 1000).toString()
                "Kilometers to Meters" -> (input * 1000).toString()
                "Miles to Kilometers" -> (input * 1.60934).toString()
                "Kilometers to Miles" -> (input / 1.60934).toString()
                else -> "Invalid length conversion"
            }
            "Weight" -> when (selectedUnit) {
                "Kilograms to Pounds" -> (input * 2.20462).toString()
                "Pounds to Kilograms" -> (input / 2.20462).toString()
                else -> "Invalid weight conversion"
            }
            else -> "Invalid conversion type"
        }
    } else {
        return "Invalid input"
    }
}
