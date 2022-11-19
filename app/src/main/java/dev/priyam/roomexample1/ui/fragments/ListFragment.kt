package dev.priyam.roomexample1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.priyam.roomexample1.R
import dev.priyam.roomexample1.adapter.StudentAdapter
import dev.priyam.roomexample1.databinding.FragmentListBinding
import dev.priyam.roomexample1.viewmodel.StudentViewModel

class ListFragment : Fragment() {

    private lateinit var _binding: FragmentListBinding
    private lateinit var viewModel: StudentViewModel
    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[StudentViewModel::class.java]
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        val studentAdapter = StudentAdapter()
        binding.rvList.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.students.observe(viewLifecycleOwner, Observer {
            studentAdapter.setData(it)
        })

    }

    override fun onResume() {
        super.onResume()
        getAllStudents()
    }

    private fun getAllStudents() {
        viewModel.getAllStudent()
    }
}