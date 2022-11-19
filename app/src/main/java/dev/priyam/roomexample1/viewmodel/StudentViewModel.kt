package dev.priyam.roomexample1.viewmodel

import android.app.Application
import androidx.lifecycle.*
import dev.priyam.roomexample1.model.Student
import dev.priyam.roomexample1.repo.StudentRepository
import dev.priyam.roomexample1.db.Studentdatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel(application: Application) : AndroidViewModel(application) {


    private var _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> = _students
    private lateinit var repository: StudentRepository

    init {
        val studentDao = Studentdatabase.getDatabase(application).getStudentDao()
        repository = StudentRepository(studentDao)
    }

    fun getAllStudent() {
        viewModelScope.launch(Dispatchers.IO) {
            val students = repository.getAllStudent()
            withContext(Dispatchers.Main) {
                _students.apply {
                    value = students
                }
            }
        }

    }

    fun addStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(student)
        }
    }

    fun deleteAllStudents() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStudents()
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStudent(student)
        }
    }
}