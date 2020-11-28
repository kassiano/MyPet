package br.com.mypet.app.features.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.core.model.User
import br.com.mypet.app.core.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val db: AppDataBase) : ViewModel() {

    val viewstate = MutableLiveData<ViewState>()

    fun createUser(name: String, cellphone: String, email: String, password: String ){

        val user = User(name = name, cellphone = cellphone, email = email, password = password);

        viewModelScope.launch(Dispatchers.IO){
            try {
                viewstate.postValue(ViewState.Loading())
                db.appDao().createUser(user)
                viewstate.postValue(ViewState.Success("Cadastro feito com sucesso"))
            } catch (t: Throwable){
                viewstate.postValue(ViewState.Error(t.message?:"Erro ao criar o usuário"))
            }
        }

    }


}