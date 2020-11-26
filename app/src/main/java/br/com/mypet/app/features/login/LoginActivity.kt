package br.com.mypet.app.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mypet.app.R
import br.com.mypet.app.features.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegisterUser.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }

}