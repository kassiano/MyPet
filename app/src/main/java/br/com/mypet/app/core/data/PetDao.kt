package br.com.mypet.app.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mypet.app.core.model.Pet

@Dao
interface PetDao {

    @Query("SELECT * FROM pet where user_id = :user_id")
    fun getPetFromUser(user_id: Int?): List<Pet>

    @Insert
    fun createPet(pet: Pet)
}