package br.com.mypet.app.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.mypet.app.R
import br.com.mypet.app.features.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegisterUser.setOnClickListener { buttonRegister() }

    }

    fun buttonRegister() {

        startActivity(Intent(this, RegisterActivity::class.java))

    }
}