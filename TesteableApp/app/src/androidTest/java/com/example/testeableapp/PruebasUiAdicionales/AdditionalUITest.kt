package com.example.testeableapp.PruebasUiAdicionales

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class AdditionalUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Test1() {
        composeTestRule.setContent { TipCalculatorScreen() }
        composeTestRule.onNodeWithText("Redondear propina").performClick()
        repeat(3) {
            composeTestRule.onNodeWithText("-").performClick()
        }
        composeTestRule.onNodeWithText("1").assertExists()
    }

    @Test
    fun Test2() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithText("Monto de la cuenta").performTextInput("1174")

        repeat(10) {
            composeTestRule.onNodeWithText("+").performClick()
        }

        composeTestRule.onNodeWithText("Total por persona:", substring = true).assertExists()
    }
}
