package com.example.cubproductions.screens

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.cubproductions.R
import com.example.cubproductions.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,
            container,false)

        Handler().postDelayed({

            if(checkLoggedIn()){
                findNavController().navigate(R.id.action_splashFragment_to_enterActivity)
            }
            else if(onBoardingFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_onboardFragment)
            }        },3500)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences(
            "onBoarding",
            Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    private fun checkLoggedIn() : Boolean{
        // check if user is logged in
        val prefs = requireActivity().getSharedPreferences(
            "test",
            AppCompatActivity.MODE_PRIVATE
        )
        prefs.getString("token", null) ?: return false
        return true
    }

}