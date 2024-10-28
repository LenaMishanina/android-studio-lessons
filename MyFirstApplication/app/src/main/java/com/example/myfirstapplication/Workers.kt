package com.example.myfirstapplication

enum class Workers(val password : Byte, val nameWorker: String, val salary: String, val photo: Int) {
    PROGRAMMER(1,"Лена", "100 тыс", R.drawable.lena),
    ARCHITECTURE(2,"Катя","1 млн", R.drawable.kate),
    COMPOSITOR(3,"Вика","3 млн", R.drawable.vika),
    DOCTOR(4,"Соня","100 тыс", R.drawable.sony),
}