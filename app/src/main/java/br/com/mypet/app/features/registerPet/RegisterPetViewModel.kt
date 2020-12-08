package br.com.mypet.app.features.registerPet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mypet.app.core.data.AppDataBase
import br.com.mypet.app.core.model.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterPetViewModel(private val db: AppDataBase) : ViewModel() {

    val liveData = MutableLiveData<Result<Boolean>>()

    fun createPet(pet: Pet){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                db.petDao().createPet(pet)
                liveData.postValue(Result.success(true))
            } catch (t: Throwable){
                liveData.postValue(Result.failure(t))
            }
        }

    }


}