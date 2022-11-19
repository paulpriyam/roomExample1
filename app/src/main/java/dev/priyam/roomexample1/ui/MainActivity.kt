package dev.priyam.roomexample1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import dev.priyam.roomexample1.R
import dev.priyam.roomexample1.db.Studentdatabase
import dev.priyam.roomexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var db: Studentdatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

//    fun insertdata() {
//        val firstName = binding.etFirstName.text.toString()
//        val lastName = binding.etLastName.text.toString()
//        val rollNumber = binding.etRollNo.text.toString()
//        if (firstName.isNotBlank() && lastName.isNotBlank() && rollNumber.isNotBlank()) {
//            val student =
//                Student(
//                    id = null,
//                    firstname = firstName,
//                    lastName = lastName,
//                    rollNo = rollNumber.toInt()
//                )
//            lifecycleScope.launch(Dispatchers.IO) {
//                db.getStudentDao().insertStudent(student)
//            }
//            binding.etFirstName.text.clear()
//            binding.etLastName.text.clear()
//            binding.etRollNo.text.clear()
//            Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
//
//        } else {
//            Toast.makeText(this, "Enter correct value", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun fetchData() {
//        val rollNumber = binding.etEnterRoll.text.toString()
//        if (rollNumber.isNotBlank()) {
//            lifecycleScope.launch(Dispatchers.IO) {
//                val student = db.getStudentDao().getStudentByRollNo(rollNumber.toInt())
//                displayData(student)
//            }
//        }
//    }
//
//    suspend fun displayData(student: Student) {
//        withContext(Dispatchers.Main) {
//            if (student.firstname.isNotEmpty()) {
//                binding.tvFirstName.text = student.firstname
//            }
//            if (student.lastName.isNotEmpty()) {
//                binding.tvLastName.text = student.lastName
//            }
//            if (student.rollNo.toString().isNotEmpty()) {
//                binding.tvRollNo.text = student.rollNo.toString()
//            }
//            if (student.lastName.isEmpty() || student.firstname.isEmpty() || student.rollNo.toString()
//                    .isEmpty()
//            ) {
//                Toast.makeText(this@MainActivity, "no result found", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}