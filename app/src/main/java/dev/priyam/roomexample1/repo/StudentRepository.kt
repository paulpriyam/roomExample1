package dev.priyam.roomexample1.repo

import dev.priyam.roomexample1.model.Student
import dev.priyam.roomexample1.db.StudentDao

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun addStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    fun getAllStudent(): List<Student> {
        return studentDao.getAllStudents()
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun deleteAllStudents() {
        studentDao.deleteAll()
    }
}