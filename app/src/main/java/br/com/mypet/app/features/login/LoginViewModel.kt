package br.com.mypet.app.features.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mypet.app.core.data.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel (
    private val db: AppDataBase
) : ViewModel(){

    val liveData = MutableLiveData<Result<Boolean>>()

    fun loginUser(email: String, password: String ){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.userDao().getEmailAndPassword(email, password)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }

    }


    fun getUserFromEmail(email: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.userDao().getUserFromEmail(email)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }
    }





}