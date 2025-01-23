package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user1 = User("1", "Lena", 20)
        user1.addAge(5)
        user1 addAge 2
        Log.d("MyLog", user1.toString())

    }
}