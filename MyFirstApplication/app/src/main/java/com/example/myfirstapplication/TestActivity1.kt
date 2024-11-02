package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myfirstapplication.databinding.ActivityTest1Binding
import kotlin.math.log

class TestActivity1 : AppCompatActivity() {
    lateinit var bind : ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        val signState = intent.getStringExtra(Constance.BTN_STATE)
        Log.d("TestActivitySign", signState.toString())

        if (signState == Constance.BTN_LOGIN_STATE) {
            bind.edtFirstName.visibility = View.GONE
            bind.edtLastName.visibility = View.GONE
            bind.edtFatherName.visibility = View.INVISIBLE
            bind.btnSetAvatar.visibility = View.INVISIBLE
        }

        bind.btnSetAvatar.setOnClickListener {
            Log.d("TestActivitySign", bind.imvAvatar2.visibility.toString())
            bind.imvAvatar2.visibility = View.VISIBLE
            Log.d("TestActivitySign", bind.imvAvatar2.visibility.toString())
        }

        bind.btnDone.setOnClickListener {
            if (signState == Constance.BTN_REGISTER_STATE)
                register()
            else if (signState == Constance.BTN_LOGIN_STATE)
                login()
        }

    }

    private fun register() {
        val login = bind.edtLogin.text.toString()
        val pwd = bind.edtPassword.text.toString()
        val firstName = bind.edtFirstName.text.toString()
        val lastName = bind.edtLastName.text.toString()
        val fatherName = bind.edtFatherName.text.toString()
        val avatarImageId = bind.imvAvatar2.imageAlpha

        if (login == "" || pwd == "" || firstName == "" || lastName == "" || fatherName == "" || bind.imvAvatar2.visibility == View.INVISIBLE) {
            Toast.makeText(applicationContext, "Заполните все поля и выберите аватара", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra(Constance.KEY_LOGIN, login)
            intent.putExtra(Constance.KEY_PWD, pwd)
            intent.putExtra(Constance.KEY_FIRST_NAME, firstName)
            intent.putExtra(Constance.KEY_LAST_NAME, lastName)
            intent.putExtra(Constance.KEY_FATHER_NAME, fatherName)
            intent.putExtra(Constance.KEY_AVATAR, avatarImageId)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    private fun login() {
        val login = bind.edtLogin.text.toString()
        val pwd = bind.edtPassword.text.toString()
        if (login == "" || pwd == "") {
            Toast.makeText(applicationContext, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
        } else {
            intent.putExtra(Constance.KEY_LOGIN, login)
            intent.putExtra(Constance.KEY_PWD, pwd)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}