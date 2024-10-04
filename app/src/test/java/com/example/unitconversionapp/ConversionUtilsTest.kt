package com.example.unitconversionapp

import com.example.unitconversionapp.helpers.convertUnits
import org.junit.Test
import org.junit.Assert.assertEquals

class ConversionUtilsTest {

    @Test
    fun testCelsiusToFahrenheit() {
        val result = convertUnits("100", "Celsius to Fahrenheit", "Temperature")
        assertEquals("212.0", result)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val result = convertUnits("32", "Fahrenheit to Celsius", "Temperature")
        assertEquals("0.0", result)
    }

    @Test
    fun testMetersToKilometers() {
        val result = convertUnits("500", "Meters to Kilometers", "Length")
        assertEquals("0.5", result)
    }

    @Test
    fun testKilogramsToPounds() {
        val result = convertUnits("10", "Kilograms to Pounds", "Weight")
        assertEquals("22.0462", result)
    }

    @Test
    fun testInvalidInput() {
        val result = convertUnits("abc", "Celsius to Fahrenheit", "Temperature")
        assertEquals("Invalid input", result) // Assuming your app returns this for invalid inputs
    }

}