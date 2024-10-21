package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    //код не исполняется
    //возможно присвоение на уровне класса
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter = 5+6
        Log.d("tagACTIVITY", "onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("tagACTIVITY", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("tagACTIVITY", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("tagACTIVITY", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("tagACTIVITY", "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d("tagACTIVITY", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("tagACTIVITY", "onRestart")
    }
}