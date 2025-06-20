package com.example.testeableapp.PruebasUnitarias

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Test
import org.junit.Assert.*

class TipCalculatorUnitTest {

    @Test
    fun tip37Round() {
        val amount = 111.0
        val tipPercent = 37
        val roundUp = true

        val result = calculateTip(amount, tipPercent, roundUp)

        assertEquals(42.0, result, 0.01)
    }

    @Test
    fun tipNegative() {
        val amount = -174.0
        val tipPercent = 12
        val roundUp = false

        val result = calculateTip(amount, tipPercent, roundUp)

        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun splitTotal() {
        val bill = 174.0
        val tip = calculateTip(bill, 8, false)
        val people = 4

        val totalPerPerson = (bill + tip) / people

        assertEquals(46.98, totalPerPerson, 0.01)
    }
}
