package com.example.appejemplocomunicacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.appejemplocomunicacion.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModelApp: ViewModelApp by activityViewModels()

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        setupUI()

    }

    private fun setupUI(){

        binding.textFirstFragment.text = "hola muchachos!"
        binding.btnNextScreen.setOnClickListener {

            viewModelApp.navigation()

        }
    }

}