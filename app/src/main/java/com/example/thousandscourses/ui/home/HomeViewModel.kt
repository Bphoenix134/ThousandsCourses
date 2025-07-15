package com.example.thousandscourses.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thousandscourses.domain.model.Course
import com.example.thousandscourses.domain.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CourseRepository
) : ViewModel() {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getCourses().collectLatest { courses ->
                _courses.value = courses
            }
        }
    }

    fun sortByPublishDate() {
        val currentCourses = _courses.value
        val sorted = currentCourses.sortedByDescending { it.publishDate }
        _courses.value = sorted
    }

    fun toggleFavorite(course: Course) {
        viewModelScope.launch {
            repository.toggleFavorite(course)
        }
    }
}