package com.artonov.viewmodellabs

import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    var number = 0

    init {
        number = incrementNumber()
    }

    fun incrementNumber(): Int {
        return number++
    }
}