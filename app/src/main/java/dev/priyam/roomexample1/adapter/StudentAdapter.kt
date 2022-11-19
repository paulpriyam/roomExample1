package dev.priyam.roomexample1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.priyam.roomexample1.R
import dev.priyam.roomexample1.databinding.ItemStudentBinding
import dev.priyam.roomexample1.model.Student
import dev.priyam.roomexample1.ui.fragments.ListFragmentDirections
import dev.priyam.roomexample1.viewmodel.StudentViewModel

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewModel>() {

    private var students = emptyList<Student>()

    inner class StudentViewModel(val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvFirstName.text = student.firstname
            binding.tvLastName.text = student.lastName
            binding.tvRollNo.text = student.rollNo.toString()
            binding.tvNumber.text = adapterPosition.toString()
            binding.root.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(student)
                binding.root.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewModel {
        return StudentViewModel(
            ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentViewModel, position: Int) {
        val currentStudent = students[position]
        holder.bind(currentStudent)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun setData(studentList: List<Student>) {
        this.students = studentList
        notifyDataSetChanged()
    }
}