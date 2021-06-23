package com.example.android.unscramble.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private val _currentWordCount=MutableLiveData(0)
    val currentWordCount:LiveData<Int>
    get() = _currentWordCount

    private val _currentScrambledWord= MutableLiveData<String>()
    val currentScrambledWord: LiveData<String>
    get() = _currentScrambledWord

    private var _count=0
    val count:Int
    get() = _count

    private val _score=MutableLiveData(0)
    val score:LiveData<Int>
    get() = _score

    private var wordList:MutableList<String> = mutableListOf()
    private lateinit var currentWord:String
    init {
        getNextWord()
    }

    private fun getNextWord(){
        currentWord= allWordsList.random()
        val tempWord=currentWord.toCharArray()
        tempWord.shuffle()

        while (tempWord.toString().equals(currentWord,false)){
            tempWord.shuffle()
        }
        if (wordList.contains(currentWord))
            getNextWord()
        else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value=_currentWordCount.value?.inc()
            wordList.add(currentWord)
        }

    }

    fun nextWord():Boolean{
        return if(_currentWordCount.value!!< MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else false
    }

    private fun increaseScore(){
        _score.value=_score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord:String):Boolean{
        if (playerWord.equals(currentWord,true)){
            increaseScore()
            return true
        }
        return false
    }
    /*
    Reintializes the game data to restart the game
     */
    fun reinitializeData(){
        _score.value=0
        _currentWordCount.value=0
        wordList.clear()
        getNextWord()
    }
}

