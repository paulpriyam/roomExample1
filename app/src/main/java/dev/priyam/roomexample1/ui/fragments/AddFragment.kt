package dev.priyam.roomexample1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import dev.priyam.roomexample1.R
import dev.priyam.roomexample1.databinding.FragmentAddBinding
import dev.priyam.roomexample1.model.Student
import dev.priyam.roomexample1.viewmodel.StudentViewModel


class AddFragment : Fragment() {

    private lateinit var _binding: FragmentAddBinding
    private lateinit var viewModel: StudentViewModel
    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        binding.btInsert.setOnClickListener {
            insertIntoDatabase()
        }
    }

    private fun insertIntoDatabase() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val rollNumber = binding.etRollNo.text.toString()
        if (firstName.isNotBlank() && lastName.isNotBlank() && rollNumber.isNotBlank()) {
            val student =
                Student(
                    id = null,
                    firstname = firstName,
                    lastName = lastName,
                    rollNo = rollNumber.toInt()
                )
            viewModel.addStudent(student)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Enter all the fills", Toast.LENGTH_SHORT).show()
        }
    }
}