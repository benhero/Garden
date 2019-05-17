package com.ben.garden.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ben.garden.PlantFragmentArgs
import com.ben.garden.R
import com.ben.garden.data.Plant
import com.ben.garden.databinding.MarketPlantListItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MarketPlanListAdapter : RecyclerView.Adapter<MarketPlanListAdapter.ViewHolder>() {
    var plants: List<Plant> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MarketPlantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return plants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = plants[position]
        holder.binding.plant = plant
        holder.binding.root.setOnClickListener {
            val bundle = PlantFragmentArgs(plant)
            Navigation.findNavController(it).navigate(R.id.action_marketFragment_to_plantFragment, bundle.toBundle())
        }
        Glide.with(holder.binding.imageView.context).load(plant.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.binding.imageView)
    }

    class ViewHolder(val binding: MarketPlantListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
