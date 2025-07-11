package com.example.thousandscourses.data.repository

import com.example.thousandscourses.data.api.CourseAPI
import com.example.thousandscourses.data.local.CourseDao
import com.example.thousandscourses.domain.model.Course
import com.example.thousandscourses.data.mapper.toDomain
import com.example.thousandscourses.data.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val courseApi: CourseAPI,
    private val courseDao: CourseDao
) {
    fun getCourse(): Flow<List<Course>> = flow {
        val courses = courseApi.getCourses()
        emit(courses)
    }

    suspend fun toggleFavorite(course: Course) {
        courseDao.insertCourse(course.toEntity())
    }

    fun getFavoriteCourses(): Flow<List<Course>> {
        return courseDao.getFavoriteCourses().map { entities ->
            entities.map { it.toDomain() }
        }
    }
}