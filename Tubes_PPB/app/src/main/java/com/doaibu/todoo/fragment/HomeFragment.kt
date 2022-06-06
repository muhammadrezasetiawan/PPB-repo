package com.doaibu.todoo.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.doaibu.todoo.R
import com.doaibu.todoo.adapter.TaskAdapter
import com.doaibu.todoo.database.DatabaseClient
import com.doaibu.todoo.database.TaskDao
import com.doaibu.todoo.database.TaskModel
import com.doaibu.todoo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var database: TaskDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        database = DatabaseClient.getService( requireActivity() ).taskDao()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
     findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        //            testInsert()

        }
        binding.listTask.adapter = taskAdapter

    }

    override fun onStart() {
        super.onStart()
        database.taskAll().observe(viewLifecycleOwner, {
            Log.e("taskAll", it.toString())
            taskAdapter.addList( it )
        })
    }
    private fun testInsert(){
        val task = TaskModel (id = 0, "Ngoding", false, 12345)

        Thread{
            database.insert( task )
            requireActivity().runOnUiThread {
                Toast.makeText(requireContext(), "Berhasil disimpan", Toast.LENGTH_SHORT).show()
            }
        }.start()
        }
    private val taskAdapter by lazy {
        TaskAdapter(arrayListOf(), object : TaskAdapter.AdapterListener{
            override fun onClick(taskModel: TaskModel) {

            }

        })
    }
}