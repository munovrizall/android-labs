package com.artonov.tipcalculator

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var tipPercent = 5
    var bill = 0
    var tip = 0
    var billTotal = 0
    var billPeople = 0
    var peopleCount = 1

}