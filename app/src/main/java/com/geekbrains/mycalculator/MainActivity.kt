package com.geekbrains.mycalculator

import android.R.*
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var arg1: Int? = null
    private var arg2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val button = findViewById<Button>(R.id.button)
        val editText1 = findViewById<TextView>(R.id.editText1)
        val editText2 = findViewById<TextView>(R.id.editText2)
        val textView = findViewById<TextView>(R.id.textView)



        button.setOnClickListener {
            try {
                arg1 = Integer.valueOf(editText1.text.toString())
                arg2 = Integer.valueOf(editText2.text.toString())
                if (arg1?.equals(arg2) == true) {
                    textView.text = "Равно!"
                } else {
                    textView.text = "Не равно!"
                }
            } catch (e: Exception) {
                textView.text = "Введите число"
            }
        }

    }
}


