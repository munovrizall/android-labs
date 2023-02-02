package com.example.guessgame

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val words = listOf<String>("Android", "Activity", "Fragment")
    val secretWord = words.random().uppercase()
    var secretWordDisplay = ""
    var correctGuesses = ""
    var incorrectGuesses = ""
    var livesLeft = 8

    init {
        Log.i("MyTAG", "ViewModel Created")
        secretWordDisplay = deriveSecretWordDisplay()
    }

    override fun onCleared() {
        Log.i("MyTAG", "ViewModel Cleared")
    }

    fun deriveSecretWordDisplay(): String {
        var display = ""
        secretWord.forEach {
            display += checkLetter(it.toString())
        }
        return display
    }

    fun checkLetter(str: String) = when (correctGuesses.contains(str)) {
        true -> str
        false -> "_"
    }

    fun makeGuess(guess: String) {
        if (guess.length == 1) {
            if (secretWord.contains(guess)) {
                correctGuesses += guess
                secretWordDisplay = deriveSecretWordDisplay()
            } else {
                incorrectGuesses += "$guess "
                livesLeft--
            }
        }
    }

    fun isWon() = secretWord.equals(secretWordDisplay, true)

    fun isLost() = livesLeft <= 0

    fun wonLostMessage(): String {
        var message = ""
        if (isWon()) message = "You won!"
        else if (isLost()) message = "You Lost!"
        message += " The word was $secretWord."
        return  message
    }
}