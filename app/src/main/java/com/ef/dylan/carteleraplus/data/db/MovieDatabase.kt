package com.ef.dylan.carteleraplus.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ef.dylan.carteleraplus.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    companion object {
        @Volatile
        private var instance : MovieDatabase? = null
        fun getDatabase(context : Context) : MovieDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "moviedb"
                ).build()
                instance = _instance
                return _instance
            }
        }
    }

}