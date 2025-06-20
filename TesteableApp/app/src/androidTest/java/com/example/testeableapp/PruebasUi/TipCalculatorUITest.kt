package com.example.testeableapp.PruebasUi

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class TipCalculatorUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun toggleRoundTip() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithText("Monto de la cuenta").performTextInput("1174")
        composeTestRule.onNodeWithText("Redondear propina").performClick()

        composeTestRule.onNodeWithText("Propina:", substring = true).assertExists()
    }

    @Test
    fun changeTipSlider() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithText("Monto de la cuenta").performTextInput("11.74")
        composeTestRule.onAllNodes(isFocusable())[0].performTouchInput {
            swipeRight()
        }

        composeTestRule.onNodeWithText("Propina:", substring = true).assertExists()
    }

    @Test
    fun checkUIElements() {
        composeTestRule.setContent { TipCalculatorScreen() }

        composeTestRule.onNodeWithText("Monto de la cuenta").assertExists()
        composeTestRule.onNodeWithText("Porcentaje de propina: 15%").assertExists()
        composeTestRule.onNodeWithText("Número de personas: 1").assertExists()
    }
}
