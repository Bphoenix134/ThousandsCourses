package com.example.thousandscourses.domain.repository

import com.example.thousandscourses.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository{
    fun getCourses() : Flow<List<Course>>
    suspend fun toggleFavorite(course: Course)
}