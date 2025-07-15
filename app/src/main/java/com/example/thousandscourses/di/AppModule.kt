package com.example.thousandscourses.di

import android.content.Context
import androidx.room.Room
import com.example.thousandscourses.data.api.CourseApi
import com.example.thousandscourses.data.local.CourseDao
import com.example.thousandscourses.data.local.CourseDatabase
import com.example.thousandscourses.data.repository.CourseRepositoryImpl
import com.example.thousandscourses.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        courseRepositoryImpl: CourseRepositoryImpl
    ): CourseRepository

    companion object {
        @Provides
        @Singleton
        fun provideCourseDatabase(@ApplicationContext context: Context): CourseDatabase {
            return Room.databaseBuilder(
                context,
                CourseDatabase::class.java,
                "course_database"
            ).addMigrations(CourseDatabase.MIGRATION_1_2).build()
        }

        @Provides
        @Singleton
        fun provideCourseDao(database: CourseDatabase): CourseDao {
            return database.courseDao()
        }

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://drive.usercontent.google.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideCourseApi(retrofit: Retrofit): CourseApi {
            return retrofit.create(CourseApi::class.java)
        }
    }
}