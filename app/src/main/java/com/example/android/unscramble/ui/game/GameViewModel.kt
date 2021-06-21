package com.example.android.unscramble.ui.game

import android.util.Log

class GameViewModel:ViewModel() {
    init {
        Log.d("Game Fragment","GameViewModel created!")
    }
    private var score=0
    private var currentWordCount=0
    private var _currentScrambledWord="test"
    val currentScrambledWord:String
    get() = _currentScrambledWord
    private var _count=0
    val count:Int
    get() = _count

    override fun onCleared(){
        super.onCleared()
        Log.d("Gameragment","GameViewModel destroyed!")
    }
    override fun onDetach(){
        super.onDetach()
        Log.d("GameFragment", "GameFragment destroyed!")
    }

}