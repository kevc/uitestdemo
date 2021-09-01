package com.kevcar.uitestdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    data class State(
        val count: Int = 0
    )

    private val _stateData: MutableLiveData<State> = MutableLiveData(State())
    val stateData: LiveData<State>
        get() = _stateData

    fun add() {
        _stateData.value = stateData.value!!.let { it.copy(count = it.count + 1) }
    }

    fun subtract() {
        _stateData.value = stateData.value!!.let { it.copy(count = it.count - 1) }
    }
}
