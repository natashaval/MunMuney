package com.example.munmuney

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.munmuney.adapter.WordListAdapter
import com.example.munmuney.entity.Word
import com.example.munmuney.viewmodel.WordViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
  private lateinit var wordViewModel: WordViewModel
  private val newWordActivityRequestCode = 1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val recyclerView = findViewById<RecyclerView>(R.id.rv_word_list)
    val adapter = WordListAdapter(this)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
    wordViewModel.allWords.observe(this, Observer { words ->
      words?.let {adapter.setWords(it)}
    })

    val fab = findViewById<FloatingActionButton>(R.id.fab_add)
    fab.setOnClickListener {
      val intent = Intent(this, NewWordActivity::class.java)
      startActivityForResult(intent, newWordActivityRequestCode)
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
      data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
        val word = Word(word = it)
        wordViewModel.insert(word)
      }
    } else {
      Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_LONG).show()
    }
  }
}