package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)//root - контейнер, где лежат все элементы

        bind.btnToTestActivity2.setOnClickListener {
            val intent = Intent(this, TestActivity2::class.java)
            startActivity(intent)
        }

        bind.btnCloseActivity.setOnClickListener {
            finish()
        }

    }
}