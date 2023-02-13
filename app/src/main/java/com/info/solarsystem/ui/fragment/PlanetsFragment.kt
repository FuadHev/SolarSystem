package com.info.solarsystem.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.se.omapi.SEService.OnConnectedListener
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResult
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.info.solarsystem.R
import com.info.solarsystem.data.entity.Planets
import com.info.solarsystem.data.entity.PlanetsItem
import com.info.solarsystem.data.retrofit.ApiUtils
import com.info.solarsystem.data.retrofit.GetPlanetsInterface
import com.info.solarsystem.databinding.FragmentPlanetsBinding
import com.info.solarsystem.ui.adapter.PlanetAdapter
import retrofit2.Call
import retrofit2.Response

class PlanetsFragment : Fragment() {
    private var _binding: FragmentPlanetsBinding?=null
    private val binding get() =_binding!!
    private lateinit var adapter: PlanetAdapter
    private lateinit var kdi: GetPlanetsInterface




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding=FragmentPlanetsBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.toolbar2?.title="Solar System"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar2)



        binding.planetsRv.setHasFixedSize(true)
        binding.planetsRv.layoutManager=StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        kdi= ApiUtils.getPlanetsInterface()
        adapter= PlanetAdapter(requireContext(), emptyList())
        binding.planetsRv.adapter=adapter
        getPlanets()

        return view
    }





    fun getPlanets(){
        kdi.getPlanets().enqueue(object :retrofit2.Callback<Planets>{
            override fun onResponse(call: Call<Planets>?, response: Response<Planets>?) {
                if(response!=null){
                    val list=response.body()

                    for(i in list){
                        Log.e("m",i.name)
                    }

                    adapter=PlanetAdapter(requireContext(),list)
                    binding.planetsRv.adapter=adapter

                }

            }

            override fun onFailure(call: Call<Planets>?, t: Throwable?) {


            }


        })


    }






}