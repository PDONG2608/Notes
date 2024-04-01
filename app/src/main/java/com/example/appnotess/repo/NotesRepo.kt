package com.example.appnotess.repo

import com.example.appnotess.data.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NotesRepo @Inject constructor(private val notesDao: NotesDao) {
    val notes = notesDao.getAllNotes()

    suspend fun getNote(id: Int) = withContext(Dispatchers.IO){
        notesDao.getSpecificNote(id)
    }

}