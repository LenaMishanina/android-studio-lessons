package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //    У нас есть интервалы которые обозначают качество оценки: bad, normal, nice, excellent.
    //    еще у нас есть массив с оценками gradeArray и массив с учениками nameArray.
    //    Ваша задача используя цикл отсортировать учеников с оценками по группам

    val bad = 0..3
    val normal = 4..6
    val nice = 7..9
    val excellent = 10
    val gradeArray = arrayOf(4, 7, 3, 6, 10, 2)
    val nameArray = arrayOf("Антон", "Егор", "Маша", "Светлана", "Юля", "Семен")
    val badArray = ArrayList<String>()
    val normalArray = ArrayList<String>()
    val niceArray = ArrayList<String>()
    val excellentArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for ((index, name) in nameArray.withIndex()) {
            when (gradeArray[index]) {
                in bad -> badArray.add("Плохие оценки: Ученик: $name – ${gradeArray[index]}")
                in normal -> normalArray.add("Нормальные оценки: Ученик: $name – ${gradeArray[index]}")
                in nice -> niceArray.add("Хорошие оценки: Ученик: $name – ${gradeArray[index]}")
                excellent -> excellentArray.add("Отличные оценки: Ученик: $name – ${gradeArray[index]}")
            }
        }
        Log.d("MyLog", badArray.toString())
        Log.d("MyLog", normalArray.toString())
        Log.d("MyLog", niceArray.toString())
        Log.d("MyLog", excellentArray.toString())

    }
}