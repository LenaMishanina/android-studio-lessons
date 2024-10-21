package com.example.myfirstapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding
    val a = 123
    val b = 56

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)//root - контейнер, где лежат все элементы

        bind.tvVar.text = "$a and $b"

        bind.btnMinus.setOnClickListener {
            val c = a - b
            bind.tvResult.text = c.toString()
        }
        bind.btnMultiple.setOnClickListener {
            val c = a * b
            bind.tvResult.text = c.toString()
        }
        bind.btnPlus.setOnClickListener {
            val c = a + b
            bind.tvResult.text = c.toString()
        }

    }
}