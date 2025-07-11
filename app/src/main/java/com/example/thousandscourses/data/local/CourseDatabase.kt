package com.example.thousandscourses.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thousandscourses.data.local.model.CourseEntity

@Database(entities = [CourseEntity::class], version = 1)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}