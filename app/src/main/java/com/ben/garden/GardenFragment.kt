package com.ben.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ben.garden.adapter.GardenPlanListAdapter
import com.ben.garden.databinding.GardenFragmentBinding
import com.ben.garden.model.GardenViewModel


class GardenFragment : Fragment() {
    private lateinit var viewModel: GardenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this.activity!!).get(GardenViewModel::class.java)
        val binding = GardenFragmentBinding.inflate(inflater, container, false)
        val adapter = GardenPlanListAdapter()
        viewModel.list.observe(this, Observer { list ->
            adapter.plants = list.sortedBy { it.buyTime }
            binding.gardenPlantList.adapter = adapter
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.fab).setOnClickListener {
            findNavController().navigate(R.id.action_gardenFragment_to_marketFragment)
        }
    }

}
