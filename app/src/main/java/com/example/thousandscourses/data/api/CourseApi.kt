package com.example.thousandscourses.data.api

import retrofit2.http.GET

data class CourseResponse(
    val courses: List<CourseDto>
)

interface CourseApi {
    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): CourseResponse
}