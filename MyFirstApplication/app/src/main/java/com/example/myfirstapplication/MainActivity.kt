package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Задача предприниматели и их заработок
    val lostArray = arrayOf(10000, 43000, 3000, 760000)//вложил
    val earnArray = arrayOf(7000, 35000, 50000, 120000)//заработал
    val result = ArrayList<String>()
    //нельзя здесь инициализировать, так как приложение еще не создано, к ресурсам нельзя обратиться
    lateinit var names : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        names = resources.getStringArray(R.array.workerNames).toList()
        for ((index, name) in names.withIndex()) {
            result.add("$name вложила ${lostArray[index]} и заработала ${earnArray[index]}. Прибыль: ${earnArray[index] - lostArray[index]}")
        }
        Log.d("MyLog", result.toString())

    }
}