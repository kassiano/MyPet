package br.com.mypet.app.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.mypet.app.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.viewmodel.ext.android.viewModel


class RegisterActivity : AppCompatActivity() {

    val viewModel by viewModel<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        createUser();
    }

    fun createUser(){
        val name = editTextName.toString()
        val cellphone = editTextCellphone.toString()
        val email = editTextEmail.toString()
        val password = editTextPassword.toString()

        btnRegisterUser.setOnClickListener {
            viewModel.createUser(name, cellphone, email, password)
        }

    }

}