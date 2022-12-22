package com.example.appejemplocomunicacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.appejemplocomunicacion.databinding.FragmentSegundoBinding


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private val viewModelApp: ViewModelApp by activityViewModels()

    private lateinit var binding: FragmentSegundoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSegundoBinding.bind(view)

        setupUI()

    }

    private fun setupUI() {
        binding.btnBack.setOnClickListener {
            viewModelApp.navigationToFirstFragment()
        }
        binding.btnToNewAct.setOnClickListener {
            viewModelApp.createNewActivity()
        }
    }

}