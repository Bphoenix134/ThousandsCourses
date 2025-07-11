package com.example.thousandscourses.domain.model

data class Course(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val participate: String,
    val hasLike: Boolean,
    val publishDate: String
)