package com.example.assignment4.screens.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    private val _taskCount = MutableLiveData<Int>()
    val taskCount: LiveData<Int>
        get() = _taskCount

    private val _task = MutableLiveData<String>()
    val task: LiveData<String>
        get() = _task

    private val _eventCompleted = MutableLiveData<Boolean>()
    val eventCompleted: LiveData<Boolean>
        get() = _eventCompleted

    private lateinit var taskList : MutableList<String>

    init {
        setTaskList()
        nextTask()
        _eventCompleted.value = false
        _taskCount.value = 0
    }

    private fun setTaskList() {
        taskList = mutableListOf(
            "Did you solve LeetCode ?",
            "Did you study Kotlin ?",
            "Did you study Android ?",
            "Did you do Assignment ?"
        )
    }

    private fun nextTask()  {
        if(taskList.isEmpty())  {
            _eventCompleted.value = true
            onTaskListComplete()
        }
        else {
            _task.value = taskList.removeAt(0)
        }
    }

    fun onSkip()    {
        nextTask()
    }

    fun onCompleted()   {
        _taskCount.value = _taskCount.value?.plus(1)
        nextTask()
    }

    fun onTaskListComplete()    {
        _eventCompleted.value = false
    }
}