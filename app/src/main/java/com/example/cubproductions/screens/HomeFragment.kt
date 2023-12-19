package com.example.cubproductions.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.cubproductions.R
import com.example.cubproductions.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fashonCard.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_homeFragment_to_fashonFragment
            )
        }

        binding.foodCard.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_homeFragment_to_foodFragment
            )
        }

        binding.weedingCard.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_homeFragment_to_weedingFragment
            )
        }

        binding.productCard.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_homeFragment_to_productFragment
            )
        }

    }

}