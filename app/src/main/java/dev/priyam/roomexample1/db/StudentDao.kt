package dev.priyam.roomexample1.db

import androidx.room.*
import dev.priyam.roomexample1.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Student)

    @Query("select * from student where rollNo like :rollNo limit 1")
    fun getStudentByRollNo(rollNo: Int): Student

    @Query("select * from student")
    fun getAllStudents(): List<Student>

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("delete from student")
    suspend fun deleteAll()

    @Update
    suspend fun updateStudent(student: Student)
}