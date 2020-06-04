package dev.rstockbridge.greetingmvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.rstockbridge.greetingmvvm.model.GreetingModel
import dev.rstockbridge.greetingmvvm.viewmodel.GreetingViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GreetingViewModelTest {
    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `One button click displays 2nd message`() {
        // arrange
        val model = GreetingModel()
        val viewModel = GreetingViewModel()

        // act
        viewModel.onButtonClicked()

        // assert
        assertEquals(viewModel.message.value, model.getMessage(1))
    }

    @Test
    fun `Two button clicks displays 3nd message`() {
        // arrange
        val model = GreetingModel()
        val viewModel = GreetingViewModel()

        // act
        viewModel.onButtonClicked()
        viewModel.onButtonClicked()

        // assert
        assertEquals(viewModel.message.value, model.getMessage(2))
    }

    @Test
    fun `Three button clicks displays 4th message`() {
        // arrange
        val model = GreetingModel()
        val viewModel = GreetingViewModel()

        // act
        viewModel.onButtonClicked()
        viewModel.onButtonClicked()
        viewModel.onButtonClicked()

        // assert
        assertEquals(viewModel.message.value, model.getMessage(3))
    }
}
