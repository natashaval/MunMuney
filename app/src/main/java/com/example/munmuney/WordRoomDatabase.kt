package com.example.munmuney

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.munmuney.dao.WordDao
import com.example.munmuney.entity.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by natasha.santoso on 28/07/20.
 */
//https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#7
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    private class WordDatabaseCallback(private val scope: CoroutineScope) :
    RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {database ->
                scope.launch {
                    var wordDao = database.wordDao()
                    wordDao.deleteAll()

                    wordDao.insert(Word(word = "Hello"))
                    wordDao.insert(Word(word = "World!"))
                    wordDao.insert(Word(word = "TODO!"))
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            return INSTANCE ?:
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}