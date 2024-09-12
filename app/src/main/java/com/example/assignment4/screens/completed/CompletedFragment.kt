package com.example.assignment4.screens.completed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.assignment4.R
import com.example.assignment4.databinding.FragmentCompletedBinding

class CompletedFragment : Fragment() {
    private lateinit var binding: FragmentCompletedBinding
    private lateinit var viewModel: CompletedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_completed, container, false
        )
        val args = CompletedFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(this).get(CompletedViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getTaskCount(args.taskCount)
        binding.doneButton.setOnClickListener { view: View ->
            view.findNavController().navigate(CompletedFragmentDirections.actionRestart())
        }
        binding.setLifecycleOwner(this)
        return binding.root
    }

}