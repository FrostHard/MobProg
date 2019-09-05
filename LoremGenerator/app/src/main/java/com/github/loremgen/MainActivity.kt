package com.github.loremgen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.creator_button).setOnClickListener {
            pickCreatorName(it)
        }
        findViewById<Button>(R.id.creator_text).setOnClickListener{
            changeCreatorName(it)
        }
    }

    private fun pickCreatorName(view: View) {
        val creatorFill = findViewById<EditText>(R.id.creator_fill)
        val creatorText = findViewById<TextView>(R.id.creator_text)

        creatorText.text = creatorFill.text

        creatorFill.visibility = View.GONE
        view.visibility = View.GONE
        creatorText.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun changeCreatorName(view: View) {
        val creatorFill = findViewById<EditText>(R.id.creator_fill)
        val creatorButton = findViewById<TextView>(R.id.creator_button)

        view.visibility = View.GONE
        creatorFill.visibility = View.VISIBLE
        creatorButton.visibility = View.VISIBLE

        creatorFill.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(creatorFill, 0)
    }
}
