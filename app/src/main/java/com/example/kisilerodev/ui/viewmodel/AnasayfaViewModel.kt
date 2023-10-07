package com.example.kisilerodev.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisilerodev.data.entity.Kisiler
import com.example.kisilerodev.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var krepo:ToDoRepository):ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    init {
        planlariYukle()
    }
    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
            planlariYukle()
        }
    }
     fun planlariYukle() {
         CoroutineScope(Dispatchers.Main).launch {
             kisilerListesi.value = krepo.planlariYukle()
         }
     }
    fun ara(aramaKelimesi:String) {
        CoroutineScope(Dispatchers.Main).launch {
           kisilerListesi.value=  krepo.ara(aramaKelimesi)
        }
    }
}
