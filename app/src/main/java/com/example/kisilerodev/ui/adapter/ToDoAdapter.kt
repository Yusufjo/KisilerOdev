package com.example.kisilerodev.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisilerodev.data.entity.Kisiler
import com.example.kisilerodev.databinding.CardTasarimBinding
import com.example.kisilerodev.ui.fragment.AnasayfaFragmentDirections
import com.example.kisilerodev.ui.viewmodel.AnasayfaViewModel
import com.example.kisilerodev.utils.gecis
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context, var viewModel:AnasayfaViewModel):RecyclerView.Adapter<ToDoAdapter.CardTasarimTutucu>() {
    var kisiListesi = listOf<Kisiler>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) :RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisiListesi[position]
        val t = holder.tasarim
        t.textViewKisiAd.text = kisi.kisi_ad

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} Silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet"){
                sil(kisi.kisi_id)
            }.show()
        }
        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(kisi = kisi)
            Navigation.gecis(it,gecis)
        }
    }

    override fun getItemCount(): Int {
       return kisiListesi.size
    }


    fun sil(kisi_id:Int){
        viewModel.sil(kisi_id)
    }
}