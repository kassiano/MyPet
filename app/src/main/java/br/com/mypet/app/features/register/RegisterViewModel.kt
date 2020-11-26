package br.com.mypet.app.features.register

import androidx.lifecycle.ViewModel
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.core.model.User

class RegisterViewModel(private val db: AppDataBase) : ViewModel() {

    fun createUser(name: String, cellphone: String, email: String, password: String ){

        val user = User(name = name, cellphone = cellphone, email = email, password = password);

        db.appDao().createUser(user)

    }


}