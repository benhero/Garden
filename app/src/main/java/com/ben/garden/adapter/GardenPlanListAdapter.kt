package com.ben.garden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ben.garden.PlantFragmentArgs
import com.ben.garden.R
import com.ben.garden.data.Plant
import com.ben.garden.databinding.GardenPlantListItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class GardenPlanListAdapter : RecyclerView.Adapter<GardenPlanListAdapter.ViewHolder>() {
    lateinit var plants: List<Plant>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(GardenPlantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = plants[position]
        holder.binding.plant = plant
        Glide.with(holder.binding.imageView.context).load(plant.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.binding.imageView)
        holder.binding.root.setOnClickListener {
            val bundle = PlantFragmentArgs(plant)
            Navigation.findNavController(it).navigate(R.id.action_gardenFragment_to_plantFragment, bundle.toBundle())
        }
    }

    class ViewHolder(val binding: GardenPlantListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
