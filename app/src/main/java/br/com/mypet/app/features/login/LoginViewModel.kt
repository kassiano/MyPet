package br.com.mypet.app.features.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.core.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel (
    private val db: AppDataBase
) : ViewModel(){

    val liveData = MutableLiveData<Result<Boolean>>()

    fun loginUser(email: String, password: String ){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.appDao().getEmailAndPassword(email, password)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }

    }





}