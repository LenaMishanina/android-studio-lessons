package com.example.myfirstapplication

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

        bind.btnGetResult.setOnClickListener {
            if (bind.edNumFollows.text.toString() == "") {
                bind.tvResult.text = "Введите количество ваших подписчиков!"
            } else {
                val numFollow = bind.edNumFollows.text.toString().toInt()

                Log.d("MainActivityLog", "Result = $numFollow")
                bind.tvResult.text = when (numFollow) {
                    in 0..1000 -> "Cool"
                    in 1000..100000 -> "Super cool"
                    else -> "Mega cool"
                }
            }
            bind.tvResult.visibility = View.VISIBLE
        }
    }
}