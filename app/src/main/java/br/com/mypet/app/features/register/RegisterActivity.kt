package br.com.mypet.app.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.mypet.app.R
import br.com.mypet.app.core.model.User
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    val viewModel by viewModel<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel.liveData.observe(this, Observer {
            if(it.isSuccess) {
                onSuccess()
            } else {
                onError()
            }
        })

        setupButton()
    }

    private fun setupButton() {

        val user = User(name = editTextName.toString(),
                        cellphone = editTextCellphone.toString(),
                        email = editTextEmail.toString(),
                        password = editTextPassword.toString())

        buttonRegister.setOnClickListener {
            viewModel.createUser(user)
        }
    }

    private fun onSuccess() {
        titleOkay.visibility = View.VISIBLE
    }

    private fun onError() {
        titleError.visibility = View.VISIBLE
    }

}