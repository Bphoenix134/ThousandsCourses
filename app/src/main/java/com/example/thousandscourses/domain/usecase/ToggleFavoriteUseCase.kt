package com.example.thousandscourses.domain.usecase

import com.example.thousandscourses.domain.model.Course
import com.example.thousandscourses.domain.repository.CourseRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    suspend operator fun invoke(course: Course) {
        repository.toggleFavorite(course.copy(hasLike = !course.hasLike))
    }
}