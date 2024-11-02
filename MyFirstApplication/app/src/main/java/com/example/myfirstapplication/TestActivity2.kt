package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityTest2Binding

class TestActivity2 : AppCompatActivity() {
    lateinit var bind : ActivityTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnCloseActivity.setOnClickListener {
            finish()
        }
    }
}