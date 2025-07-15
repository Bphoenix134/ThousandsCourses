package com.example.thousandscourses.data.api

import com.example.thousandscourses.domain.model.Course

data class CourseDto(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)

fun CourseDto.toDomain() = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = "",
    hasLike = hasLike,
    publishDate = publishDate,
    startDate = startDate
)

fun CourseDto.toEntity() = com.example.thousandscourses.data.local.model.CourseEntity(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = "",
    hasLike = hasLike,
    publishDate = publishDate,
    startDate = startDate
)
