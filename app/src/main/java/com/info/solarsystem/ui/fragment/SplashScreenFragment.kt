package com.info.solarsystem.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.info.solarsystem.R
import com.info.solarsystem.data.entity.Planets
import com.info.solarsystem.data.retrofit.ApiUtils
import com.info.solarsystem.data.retrofit.GetPlanetsInterface
import com.info.solarsystem.databinding.FragmentSplashScreenBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {
    private var _binding:FragmentSplashScreenBinding?=null
    private val binding get() =_binding!!
    private var splashscreen=2000


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding=FragmentSplashScreenBinding.inflate(inflater,container,false)
        val view=binding.root







        Handler(Looper.myLooper()!!).postDelayed({

        findNavController().navigate(R.id.splash_to_planet)


        },splashscreen.toLong())





        return view



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}