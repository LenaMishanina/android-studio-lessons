package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityTest1Binding

class TestActivity1 : AppCompatActivity() {
    lateinit var bind : ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key1", "Hello, i'm from TaskActivity1")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}