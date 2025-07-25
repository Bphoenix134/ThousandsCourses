package com.example.thousandscourses.domain.usecase

import com.example.thousandscourses.domain.model.Course
import com.example.thousandscourses.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(): Flow<List<Course>>{
        return repository.getCourses()
    }
}