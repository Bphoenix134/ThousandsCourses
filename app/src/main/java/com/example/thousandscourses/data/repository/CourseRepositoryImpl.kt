package com.example.thousandscourses.data.repository

import com.example.thousandscourses.data.api.CourseApi
import com.example.thousandscourses.data.local.CourseDao
import com.example.thousandscourses.data.mapper.toDomain
import com.example.thousandscourses.domain.model.Course
import com.example.thousandscourses.data.mapper.toEntity
import com.example.thousandscourses.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val courseApi: CourseApi,
    private val courseDao: CourseDao
) : CourseRepository {
    override fun getCourses(): Flow<List<Course>> = flow {
        val response = courseApi.getCourses()
        response.courses.forEach { courseDto ->
            courseDao.insertCourse(courseDto.toEntity())
        }
        emitAll(courseDao.getCourses().map { entities -> entities.map { it.toDomain() } })
    }

    override suspend fun toggleFavorite(course: Course) {
        courseDao.insertCourse(course.copy(hasLike = !course.hasLike).toEntity())
    }
}