package com.example.thousandscourses.data.mapper

import com.example.thousandscourses.data.api.CourseDto
import com.example.thousandscourses.data.local.model.CourseEntity
import com.example.thousandscourses.domain.model.Course

fun Course.toEntity() = CourseEntity(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = participate,
    hasLike = hasLike,
    publishDate = publishDate,
    startDate = startDate
)

fun CourseEntity.toDomain() = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = participate,
    hasLike = hasLike,
    publishDate = publishDate,
    startDate = startDate
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

fun CourseDto.toEntity() = CourseEntity(
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