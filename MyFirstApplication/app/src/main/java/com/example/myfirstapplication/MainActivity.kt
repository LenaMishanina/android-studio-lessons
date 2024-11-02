package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)//root - контейнер, где лежат все элементы


        bind.btnToTestActivity1.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            intent.putExtra("key", "hello, what's your name?")// putExtra(key, value)
            startActivityForResult(intent, 100)//100 - идентификатор запроса
        }
    }
    // получение результата от TestActivity1
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val request = data.getStringExtra("answer_name")
            bind.tvMessage.text = request
        } else if (requestCode == 100 && resultCode == RESULT_CANCELED) {
            bind.tvMessage.text = "Вы не ввели ответ"
        }
    }
}