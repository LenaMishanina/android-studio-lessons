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
            val workerName = bind.spinnerName.selectedItem.toString()
            Log.d("MainActivityLog", "Result = $workerName")
            if (bind.edPassword.text.toString() == ""){
                bind.tvResult.text = "Введите пароль"
            } else {
                bind.tvResult.text = when (workerName) {
                    Workers.PROGRAMMER.nameWorker -> getSalary(Workers.PROGRAMMER)
                    Workers.ARCHITECTURE.nameWorker -> getSalary(Workers.ARCHITECTURE)
                    Workers.COMPOSITOR.nameWorker -> getSalary(Workers.COMPOSITOR)
                    Workers.DOCTOR.nameWorker -> getSalary(Workers.DOCTOR)
                    else -> "I don't understand you"
                }
            }
            bind.tvResult.visibility = View.VISIBLE
        }
    }
    private fun getSalary(worker : Workers) : String {
        var salary = ""

        val pwd = bind.edPassword.text.toString().toByte()

        salary = when (worker) {
            Workers.PROGRAMMER -> getResFromPwd(pwd, Workers.PROGRAMMER)
            Workers.ARCHITECTURE -> getResFromPwd(pwd, Workers.ARCHITECTURE)
            Workers.COMPOSITOR -> getResFromPwd(pwd, Workers.COMPOSITOR)
            Workers.DOCTOR -> getResFromPwd(pwd, Workers.DOCTOR)
        }

        return salary
    }

    private fun getResFromPwd(pwd : Byte, worker : Workers) : String {
        var salary = "Неверно введен пароль"
        if (pwd == worker.password)
            salary = worker.salary

        return salary
    }
}