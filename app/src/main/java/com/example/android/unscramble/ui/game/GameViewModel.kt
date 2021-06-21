package com.example.android.unscramble.ui.game

class GameViewModel:ViewModel() {
    private var score=0
    private var currentWordCount=0
    private var _currentScrambledWord="test"
    val currentScrambledWord:String
    get() = _currentScrambledWord
    private var _count=0
    val count:Int
    get() = _count
}