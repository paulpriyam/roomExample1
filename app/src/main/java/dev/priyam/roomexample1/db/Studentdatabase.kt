package dev.priyam.roomexample1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.priyam.roomexample1.model.Student

@Database(entities = [Student::class], version = 1)
abstract class Studentdatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: Studentdatabase? = null

        fun getDatabase(context: Context): Studentdatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Studentdatabase::class.java,
                    "student_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}