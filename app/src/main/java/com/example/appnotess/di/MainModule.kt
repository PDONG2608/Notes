package com.example.appnotess.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appnotess.data.NotesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): NotesDataBase =
        Room.databaseBuilder(context, NotesDataBase::class.java, "notes.db").build()

    @Provides
    fun providesNotesDao(dataBase: NotesDataBase) = dataBase.noteDao()

}