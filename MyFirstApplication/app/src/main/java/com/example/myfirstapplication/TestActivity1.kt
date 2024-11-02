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

        bind.btnToMainActivity.setOnClickListener {
//            сообщение системе андройд, которая запустит активити
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)//запустить активити
        }


    }
}