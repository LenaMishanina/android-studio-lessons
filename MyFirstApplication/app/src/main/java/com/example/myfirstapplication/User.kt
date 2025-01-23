package com.example.myfirstapplication

class User(var id: String, var name: String, var age: Byte) {
    infix fun addAge(years: Byte) {
        age = age.plus(years).toByte()
    }

    override fun toString(): String {
        return "User(id='$id', name='$name', age=$age)"
    }

}