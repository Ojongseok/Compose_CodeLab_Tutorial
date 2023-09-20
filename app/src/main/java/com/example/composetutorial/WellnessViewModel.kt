package com.example.composetutorial

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

//    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
//        tasks.find {
//            it.id == item.id
//        }?.let { task ->
//            task.checked = checked
//        }
//    }
    fun changeTaskChecked(item: WellnessTask) {
        tasks.find {
            it.id == item.id
        }?.let { task ->
            task.checked = !task.checked
        }
    }
}