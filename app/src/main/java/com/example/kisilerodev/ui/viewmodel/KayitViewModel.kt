package com.example.kisilerodev.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisilerodev.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor (var krepo:ToDoRepository):ViewModel() {
     fun kaydet(kisi_ad:String){
       CoroutineScope(Dispatchers.Main).launch {
           krepo.kaydet(kisi_ad)
       }

    }
}