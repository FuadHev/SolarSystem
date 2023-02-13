package com.info.solarsystem.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.info.solarsystem.R
import com.info.solarsystem.data.entity.Planets
import com.info.solarsystem.data.entity.PlanetsItem
import com.info.solarsystem.ui.fragment.PlanetsFragmentDirections

class PlanetAdapter(private val mContext: Context,private val planetList:List<PlanetsItem>):RecyclerView.Adapter<PlanetAdapter.CardViewHolder>() {

    inner class CardViewHolder(view: View):RecyclerView.ViewHolder(view){
        var planet_Name:TextView
        var planetCard:CardView
        var planet_mass:TextView
        var planet_volume:TextView
        var planet_image:ImageView
        var goToInfo:ImageView

        init {
            planetCard=view.findViewById(R.id.planetCard)
            planet_Name=view.findViewById(R.id.planet_Name)
            planet_mass=view.findViewById(R.id.planet_mass)
            planet_volume=view.findViewById(R.id.planet_volume)
            planet_image=view.findViewById(R.id.planet_image)
            goToInfo=view.findViewById(R.id.goToInfo)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view=
            LayoutInflater.from(mContext).inflate(R.layout.planets_card_view,parent,false)
        return CardViewHolder(view)


    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val planet=planetList[position]
        holder.planet_Name.text=planet.name
        for (i in planet.basicDetails){
            holder.planet_mass.text="Mass: ${i.mass}"
            holder.planet_volume.text="Volume: ${i.volume}"


        }
        holder.goToInfo.setOnClickListener {

            val goTo=PlanetsFragmentDirections.planetsToInfoPlanet(planetsItem = planet)
            Navigation.findNavController(it).navigate(goTo)


        }
        holder.planet_image.setImageResource(mContext.resources.getIdentifier(planet.name.lowercase(),"drawable",mContext.packageName))






    }



    override fun getItemCount(): Int {
        return planetList.size
    }


}