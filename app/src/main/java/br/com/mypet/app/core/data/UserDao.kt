package br.com.mypet.app.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mypet.app.core.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user where id = :id")
    fun getUser(id: Int?): List<User>

    @Insert
    fun createUser(user: User)
}