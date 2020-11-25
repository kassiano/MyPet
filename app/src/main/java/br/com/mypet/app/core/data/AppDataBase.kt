package br.com.mypet.app.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.mypet.app.core.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao() : AppDao
}