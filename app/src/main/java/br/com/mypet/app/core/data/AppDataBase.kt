package br.com.mypet.app.core.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mypet.app.core.model.Pet
import br.com.mypet.app.core.model.User

@Database(entities = [User::class, Pet::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao

    abstract fun petDao() : PetDao
}