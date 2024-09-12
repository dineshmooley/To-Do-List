package com.example.assignment4.screens.completed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class CompletedViewModel : ViewModel() {
    private val _taskCount = MutableLiveData<Int>()
    val taskCount: LiveData<Int>
        get() = _taskCount

    fun getTaskCount(count: Int) {
        _taskCount.value = count
    }
}