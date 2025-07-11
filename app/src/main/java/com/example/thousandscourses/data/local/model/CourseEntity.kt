package com.example.thousandscourses.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val participate: String,
    val hasLike: Boolean,
    val publishDate: String
)
