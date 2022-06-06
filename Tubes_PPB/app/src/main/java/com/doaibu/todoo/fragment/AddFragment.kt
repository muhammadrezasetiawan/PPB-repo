package com.doaibu.todoo.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.doaibu.todoo.R
import com.doaibu.todoo.database.DatabaseClient
import com.doaibu.todoo.database.TaskDao
import com.doaibu.todoo.database.TaskModel
import com.doaibu.todoo.databinding.FragmentAddBinding
import com.doaibu.todoo.util.dateToDialog
import com.doaibu.todoo.util.dateToLong
import com.doaibu.todoo.util.dateToString
import com.doaibu.todoo.util.dateToday

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var database: TaskDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        database = DatabaseClient.getService( requireActivity() ).taskDao()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textDate.text = dateToday()
        binding.labelDate.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.textDate.text = dateToString(year, month, dayOfMonth)
            }
            dateToDialog( requireActivity(), datePicker ).show()
        }
        binding.buttonSave.setOnClickListener {
            val task = TaskModel (
                id = 0,
                binding.editTask.text.toString(),
                false,
                dateToLong( binding.textDate.text.toString() )
            )
            Thread{
                database.insert( task )
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Tugas berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }.start()
        }
    }
}