package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding
    private var login = ""
    private var pwd = ""
    private var firstName = ""
    private var lastName = ""
    private var fatherName = ""
    private var avatarImageId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnRegister.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            intent.putExtra(Constance.BTN_STATE, Constance.BTN_REGISTER_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_REGISTER)
        }

        bind.btnLogin.setOnClickListener {
            val intent = Intent(this, TestActivity1::class.java)
            intent.putExtra(Constance.BTN_STATE, Constance.BTN_LOGIN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_LOGIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.REQUEST_CODE_REGISTER && resultCode == RESULT_OK && data != null) {
            login = data.getStringExtra(Constance.KEY_LOGIN).toString()
            pwd = data.getStringExtra(Constance.KEY_PWD).toString()
            firstName = data.getStringExtra(Constance.KEY_FIRST_NAME).toString()
            lastName = data.getStringExtra(Constance.KEY_LAST_NAME).toString()
            fatherName = data.getStringExtra(Constance.KEY_FATHER_NAME).toString()
            avatarImageId = data.getIntExtra(Constance.KEY_AVATAR, bind.imvAvatar.imageAlpha)
            bind.tvResult.text = "Вы успешно зарегистрировались!"
        } else if (requestCode == Constance.REQUEST_CODE_LOGIN && resultCode == RESULT_OK && data != null) {
            if (login == data.getStringExtra(Constance.KEY_LOGIN) && pwd == data.getStringExtra(Constance.KEY_PWD)) {
                val message = "Вы успешно вошли!\nLogin = $login;\n" +
                        "Pwd = $pwd;\n" +
                        "FirstName = $firstName;\n" +
                        "LastName = $lastName;\n" +
                        "FatherName = $fatherName;\n" +
                        "AvatarImage = $avatarImageId."
                bind.tvResult.text = message
                bind.imvAvatar.visibility = View.VISIBLE
            } else {
                bind.tvResult.text = "Логин или пароль введены неверно"
            }
        }
    }

}