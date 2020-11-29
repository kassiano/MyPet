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

    val liveData = MutableLiveData<Result<Boolean>>()

    fun createUser(name: String, cellphone: String, email: String, password: String ){

        val user = User(name = name, cellphone = cellphone, email = email, password = password);

        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.appDao().createUser(user)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }

    }


}