package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding
    lateinit var launcher: ActivityResultLauncher<Intent> // один запрос - один launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            // request_code здесь не нужен, так как один запрос - один launcher
            if (result.resultCode == RESULT_OK && result.data != null) {
                val text = result.data!!.getStringExtra("key1").toString() //intent
                bind.textView.text = text
            }

        }

        bind.button2.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            launcher.launch(intent)
        }

    }
}