package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var edit_text : EditText
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val motsSpecifiques = listOf("mot1", "mot2", "mot3")
        mediaPlayer = MediaPlayer.create(this, R.raw.alerte)
        edit_text = findViewById(R.id.editText)

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val motTape = s.toString().toLowerCase(Locale.getDefault())
                if (motsSpecifiques.contains(motTape)) {
                    mediaPlayer.start()
                }
            }
        })
    }
}