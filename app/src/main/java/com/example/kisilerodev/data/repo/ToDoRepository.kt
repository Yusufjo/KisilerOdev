package com.example.kisilerodev.data.repo

import com.example.kisilerodev.data.datasource.ToDoDataSource
import com.example.kisilerodev.data.entity.Kisiler
import com.example.kisilerodev.room.ToDoDao

class ToDoRepository(var kds:ToDoDataSource) {

    suspend fun kaydet(kisi_ad:String) = kds.kaydet(kisi_ad)

    suspend fun guncelle(kisi_id:Int,kisi_ad:String) = kds.guncelle(kisi_id,kisi_ad)

    suspend fun sil(kisi_id:Int) = kds.sil(kisi_id)

    suspend fun planlariYukle():List<Kisiler> = kds.planlariYukle()

    suspend fun ara(aramaKelimesi:String):List<Kisiler> = kds.ara(aramaKelimesi)

}