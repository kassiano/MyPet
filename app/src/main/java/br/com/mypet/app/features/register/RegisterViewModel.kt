package br.com.mypet.app.features.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.core.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val db: AppDataBase) : ViewModel() {

    val liveData = MutableLiveData<Result<Boolean>>()

    fun createUser(user: User){

        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.userDao().createUser(user)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }

    }


}