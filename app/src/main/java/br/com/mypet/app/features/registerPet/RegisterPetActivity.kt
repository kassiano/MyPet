package br.com.mypet.app.features.registerPet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.com.mypet.app.R
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import br.com.mypet.app.features.home.HomeActivity


class RegisterPetActivity : AppCompatActivity() {

    val viewModel by viewModel<RegisterPetViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_pet)

        viewModel.liveData.observe(this, Observer {
            if(it.isSuccess) {
                onSuccess()
            } else {
                onError()
            }
        })

        setupButton()
    }


    private fun setupButton(){
        //pegar os dados do layout e passar para o new Pet
    }

    fun onSuccess(){
        startActivity(Intent(this, HomeActivity::class.java))

    }
    fun onError(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Erro na criação")
        builder.setMessage("verifique os dados")
        builder.setPositiveButton("Ok") { _, _ ->
        }
        builder.show()

    }
}
