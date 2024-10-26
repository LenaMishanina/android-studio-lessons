package com.example.myfirstapplication

enum class Workers(val password : Byte, val nameWorker: String, val salary: String) {
    PROGRAMMER(1,"Лена", "100 тыс"),
    ARCHITECTURE(2,"Катя","1 млн"),
    COMPOSITOR(3,"Вика","3 млн"),
    DOCTOR(4,"Соня","100 тыс"),
}