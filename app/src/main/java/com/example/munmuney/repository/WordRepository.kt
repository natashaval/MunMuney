package com.example.munmuney.repository

import androidx.lifecycle.LiveData
import com.example.munmuney.dao.WordDao
import com.example.munmuney.entity.Word

/**
 * Created by natasha.santoso on 28/07/20.
 */
class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}