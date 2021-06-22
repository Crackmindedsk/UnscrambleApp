package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    init {
        Log.d("Game Fragment","GameViewModel created!")
        getNextWord()
    }
    private var score=0
    private var currentWordCount=0
    private lateinit var _currentScrambledWord:String
    val currentScrambledWord:String
    get() = _currentScrambledWord

    private var _count=0
    val count:Int
    get() = _count

    private var _score=0
    val score:Int
    get() = _score

    override fun onCleared(){
        super.onCleared()
        Log.d("Gameragment","GameViewModel destroyed!")
    }

    private val wordList:MutableList<String> = mutableListOf()
    private lateinit var currentWord:String
    private fun getNextWord(){
        currentWord= allWordsList.random()
        val tempWord=currentWord.toCharArray()
        while (tempWord.toString().equals(currentWord,false)){
            tempWord.shuffle()
        }
        if (wordList.contains(currentWord))
            getNextWord()
        else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordList.add(currentWord)
        }

    }

    private fun nextWord():Boolean{
        return if(currentWordCount< MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else false
    }


}

