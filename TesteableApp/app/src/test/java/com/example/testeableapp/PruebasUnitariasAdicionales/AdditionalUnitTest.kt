package com.example.testeableapp.PruebasUnitariasAdicionales

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class AdditionalUnitTest {

    @Test
    fun Test1() {
        val amount = 1174.0
        val tipPercent = 4
        val roundUp = true

        val result = calculateTip(amount, tipPercent, roundUp)

        assertEquals(47.0, result, 0.01)
    }

    @Test
    fun Test2() {
        val amount = 100.0
        val tipPercent = 9
        val roundUp = false

        val result = calculateTip(amount, tipPercent, roundUp)

        assertEquals(9.0, result, 0.01)
    }
}
