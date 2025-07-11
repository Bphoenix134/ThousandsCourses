package com.example.thousandscourses.data.mapper

import com.example.thousandscourses.data.local.model.CourseEntity
import com.example.thousandscourses.domain.model.Course

private fun Course.toEntity() = CourseEntity(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = participate,
    hasLike = hasLike,
    publishDate = publishDate
)

private fun CourseEntity.toDomain() = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    participate = participate,
    hasLike = hasLike,
    publishDate = publishDate
)