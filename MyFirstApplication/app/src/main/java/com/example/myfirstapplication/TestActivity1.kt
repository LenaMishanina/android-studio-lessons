package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityTest1Binding

class TestActivity1 : AppCompatActivity() {
    lateinit var bind : ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        val message = intent.getStringExtra("key")
        bind.tvMessage.text = message

        bind.btnBackToMainActivity.setOnClickListener {
            val answer = bind.edtAnswer.text.toString()
            intent.putExtra("answer_name", answer)
            if (answer == "") {
                setResult(RESULT_CANCELED)
            } else {
                setResult(RESULT_OK, intent)
            }
            finish()
        }

    }
}