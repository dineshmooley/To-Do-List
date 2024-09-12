package com.example.assignment4.screens.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.assignment4.R
import com.example.assignment4.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task, container, false)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.eventCompleted.observe(viewLifecycleOwner, Observer { hasCompleted ->
            if (hasCompleted) {
                tasksCompleted()
                viewModel.onTaskListComplete()
            }
        })

        return binding.root
    }

    private fun tasksCompleted()    {
        val action = TaskFragmentDirections.actionTaskToCompleted()
        action.setTaskCount(viewModel.taskCount.value ?: 0)
        findNavController(this).navigate(action)
    }
}