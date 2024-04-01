package com.example.appnotess.data

import androidx.room.*
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Query("SELECT * FROM NOTES ORDER BY ID DESC")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Query("SELECT * FROM NOTES WHERE id = :id")
    suspend fun getSpecificNote(id: Int): NotesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes : NotesEntity)

    @Delete
    suspend fun deleteNotes(notes: NotesEntity)

    @Query("DELETE FROM NOTES WHERE id = :id")
    suspend fun deleteSpecificNote(id: Int)

    @Update
    suspend fun updateNotes(notes: NotesEntity)
}