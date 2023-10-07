package com.example.kisilerodev.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisilerodev.data.entity.Kisiler


@Dao
interface ToDoDao {
    @Query("SELECT * FROM ToDo")
    suspend fun planlariYukle():List<Kisiler>

    @Insert
    suspend fun yeniPlanEkle(plan:Kisiler)

    @Update
    suspend fun guncelle(guncellenecekPlan:Kisiler)

    @Delete
    suspend fun sil(plan: Kisiler)

    @Query("SELECT * FROM ToDo WHERE kisi_ad like '%' || :aramakelimesi || '%'")
    suspend fun ara(aramakelimesi:String):List<Kisiler>
}