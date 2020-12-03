package br.com.mypet.app.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import br.com.mypet.app.R
import br.com.mypet.app.features.home.HomeActivity
import br.com.mypet.app.features.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {

    val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegisterUser.setOnClickListener { buttonRegister() }

        viewModel.liveData.observe(this, Observer {
            if(it.isSuccess){
                onSuccess()
            }else {
                onError()
            }
        })

        setupButtonLogin()

    }


    fun setupButtonLogin(){
        btnEnterLogin.setOnClickListener {
            val email = editTextLoginEmail.text.toString()
            val password = editTextLoginPassword.text.toString()

            if(email.isEmpty()){
                editTextLoginEmail.error = "Preencha"
                return@setOnClickListener
            }

            if(password.isEmpty()){
                editTextLoginPassword.error = "Preencha"
                return@setOnClickListener
            }

            makeLoginUser(email, password)
        }
    }

    fun makeLoginUser(email: String, password: String){
        viewModel.loginUser(email,password)
    }

    fun buttonRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun onSuccess(){
        startActivity(Intent(this, HomeActivity::class.java))

    }
    fun onError(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Erro no login")
        builder.setMessage("verifique email e senha")
        builder.setPositiveButton("Ok") { _, _ ->
        }
        builder.show()

    }
}