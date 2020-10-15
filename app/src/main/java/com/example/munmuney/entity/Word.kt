package com.example.munmuney.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by natasha.santoso on 28/07/20.
 */
@Entity(tableName = "word_table")
data class Word (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "word") val word: String
)