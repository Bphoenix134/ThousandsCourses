package com.example.thousandscourses.data.api

import com.example.thousandscourses.domain.model.Course
import retrofit2.http.GET

interface CourseAPI {
    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): List<Course>
}