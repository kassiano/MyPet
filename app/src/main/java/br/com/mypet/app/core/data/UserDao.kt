package br.com.mypet.app.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mypet.app.core.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user where email = :email")
    fun getUserFromEmail(email: String?): List<User>

    @Query("SELECT * FROM user where email = :email and password = :password")
    fun getEmailAndPassword(email: String?, password: String?) : List<User>

    @Insert
    fun createUser(user: User)
}