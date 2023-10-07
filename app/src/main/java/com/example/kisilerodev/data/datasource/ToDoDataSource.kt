package com.example.kisilerodev.data.datasource

import com.example.kisilerodev.data.entity.Kisiler
import com.example.kisilerodev.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDoDao: ToDoDao) {
   suspend fun kaydet(kisi_ad: String){
       val yeniPlan = Kisiler(0,kisi_ad)
       toDoDao.yeniPlanEkle(yeniPlan)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String){
        val guncellenenPlan = Kisiler(kisi_id,kisi_ad)
        toDoDao.guncelle(guncellenenPlan)
    }

    suspend fun sil(kisi_id:Int){
        val silinenPlan = Kisiler(kisi_id,"")
        toDoDao.sil(silinenPlan)
    }

    suspend fun planlariYukle():List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext toDoDao.planlariYukle()
    }

    suspend fun ara(aramaKelimesi:String):List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext toDoDao.ara(aramaKelimesi)
    }
}