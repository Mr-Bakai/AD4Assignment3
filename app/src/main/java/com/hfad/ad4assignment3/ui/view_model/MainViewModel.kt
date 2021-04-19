package com.hfad.ad4assignment3.ui.view_model
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mCounter = 0
    private val builder = StringBuilder()

    val counter = MutableLiveData<Int>()
    val counterText = MutableLiveData<String>()

    fun onIncrementClick() {
        builder.append(" ").append("+")
        counterText.value = builder.toString()
        counter.value = ++mCounter
    }

    fun onSubtractClick() {
        builder.append(" ").append("-")
        counterText.value = builder.toString()
        counter.value = --mCounter
    }

    init {
        counter.postValue(0)
        counterText.postValue("")
    }
}