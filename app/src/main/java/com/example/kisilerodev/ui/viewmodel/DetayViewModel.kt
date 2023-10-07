package com.example.kisilerodev.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisilerodev.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor (var drepo:ToDoRepository):ViewModel(){

     fun guncelle(kisi_id: Int, kisi_ad: String){
       CoroutineScope(Dispatchers.Main).launch {
           drepo.guncelle(kisi_id,kisi_ad)
       }
    }
}