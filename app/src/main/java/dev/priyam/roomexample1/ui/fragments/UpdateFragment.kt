package dev.priyam.roomexample1.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dev.priyam.roomexample1.R
import dev.priyam.roomexample1.databinding.FragmentUpdateBinding
import dev.priyam.roomexample1.model.Student
import dev.priyam.roomexample1.viewmodel.StudentViewModel


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var _binding: FragmentUpdateBinding
    private lateinit var viewmodel: StudentViewModel

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(requireActivity())[StudentViewModel::class.java]
        setHasOptionsMenu(true)
        binding.etFirstName.setText(args.currentStudent.firstname)
        binding.etLastName.setText(args.currentStudent.lastName)
        binding.etRollNo.setText(args.currentStudent.rollNo.toString())
        binding.btInsert.setOnClickListener {
            updateStudent()
        }
    }

    private fun updateStudent() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val rollNumber = binding.etRollNo.text.toString()
        if (firstName.isNotBlank() && lastName.isNotBlank() && rollNumber.isNotBlank()) {
            val student =
                Student(
                    id = args.currentStudent.id,
                    firstname = firstName,
                    lastName = lastName,
                    rollNo = rollNumber.toInt()
                )
            viewmodel.updateStudent(student)
            Toast.makeText(requireContext(), "Successfully updated", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuDelete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewmodel.deleteStudent(args.currentStudent)
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.setTitle("delete ${args.currentStudent.firstname}")
        builder.setMessage("Are you sure you want tot delete ${args.currentStudent.firstname}")
        builder.create().show()

    }
}