package com.example.kisilerodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisilerodev.databinding.FragmentDetayBinding
import com.example.kisilerodev.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentDetayBinding.inflate(inflater, container, false)
        val bundle:DetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)


        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()

            val kisi_id = gelenKisi.kisi_id
            guncelle(kisi_id,kisi_ad)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun guncelle(kisi_id:Int,kisi_ad:String) {
        viewModel.guncelle(kisi_id,kisi_ad)
    }
}