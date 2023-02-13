package com.info.solarsystem.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.info.solarsystem.databinding.FragmentInfoPlanetBinding
import com.squareup.picasso.Picasso

class InfoPlanetFragment : Fragment() {
    private var _binding: FragmentInfoPlanetBinding?=null
    private val binding get() =_binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding=FragmentInfoPlanetBinding.inflate(inflater,container,false)
        val view=binding.root

        val bundle:InfoPlanetFragmentArgs by navArgs()
        val planet=bundle.planetsItem
        for (i in planet.imgSrc){
            val url=i.img
           Picasso.get().load(url).into(binding.olanetImage)
            binding.imgInfo.text=i.imgDescription
        }
        binding.planetName.text=planet.name
        binding.planetInfo.text=planet.description


        binding.goToWipipedia.setOnClickListener {

            val url = planet.wikiLink

            val openUrl=Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data= Uri.parse(url)
            requireContext().startActivity(openUrl)


        }


        Log.e("nam",planet.name)







        return view
    }


}