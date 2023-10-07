package com.example.kisilerodev.di

import android.content.Context
import androidx.room.Room
import com.example.kisilerodev.data.datasource.ToDoDataSource
import com.example.kisilerodev.data.repo.ToDoRepository
import com.example.kisilerodev.room.ToDoDao
import com.example.kisilerodev.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleApp {
    @Provides
    @Singleton
    fun provideToDoRepository(kds:ToDoDataSource): ToDoRepository {
        return ToDoRepository(kds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDao: ToDoDao): ToDoDataSource {
        return ToDoDataSource(toDoDao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"ToDo.sqlite").createFromAsset("ToDo.sqlite").build()
        return vt.getToDoDao()
    }
}