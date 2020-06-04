package dev.rstockbridge.greetingmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dev.rstockbridge.greetingmvvm.model.GreetingModel

class GreetingViewModel : ViewModel() {
    private val model: GreetingModel = GreetingModel()
    private val clickCount = MutableLiveData(0)
    val message: LiveData<String> = Transformations.map(clickCount, model::getMessage)

    fun onButtonClicked() {
        clickCount.value = clickCount.value!! + 1
    }
}
