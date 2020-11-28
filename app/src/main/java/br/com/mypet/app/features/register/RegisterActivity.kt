package br.com.mypet.app.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.mypet.app.R
import br.com.mypet.app.core.viewstate.ViewState
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.viewmodel.ext.android.viewModel


class RegisterActivity : AppCompatActivity() {

    val viewModel by viewModel<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel.viewstate.observe(this, Observer(::createUser))

    }

    fun createUser(viewstate: ViewState?){
        val name = editTextName.toString()
        val cellphone = editTextCellphone.toString()
        val email = editTextEmail.toString()
        val password = editTextPassword.toString()

        viewstate?.let {

            when(viewstate){

                is ViewState.Success ->{
                    btnRegisterUser.setOnClickListener {
                        viewModel.createUser(name, cellphone, email, password)
                    }

                    titleOkay.visibility = View.VISIBLE
                }

                is ViewState.Error ->{
                    titleError.visibility = View.VISIBLE

                }

                is ViewState.Loading ->{

                }

            }
        }



    }

}