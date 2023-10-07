package com.example.kisilerodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisilerodev.R
import com.example.kisilerodev.databinding.FragmentAnasayfaBinding
import com.example.kisilerodev.ui.adapter.ToDoAdapter
import com.example.kisilerodev.ui.viewmodel.AnasayfaViewModel
import com.example.kisilerodev.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        val kisiAdapter = ToDoAdapter(requireContext(),viewModel)
        binding.rv.adapter = kisiAdapter
       viewModel.kisilerListesi.observe(viewLifecycleOwner){
           kisiAdapter.kisiListesi = it

       }





        binding.floatingActionButton.setOnClickListener {
            Navigation.gecis(it,R.id.kayitGecis)
        }


        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return false
            }
        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun ara(aramaKelimesi:String){
        viewModel.ara(aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
       viewModel.planlariYukle()
    }
}