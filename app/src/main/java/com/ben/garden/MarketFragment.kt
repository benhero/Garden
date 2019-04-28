package com.ben.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.ben.garden.adapter.MarketPlanListAdapter
import com.ben.garden.data.Plant
import com.ben.garden.databinding.MarketFragmentBinding
import com.ben.garden.model.MarketViewModel


class MarketFragment : Fragment() {

    private lateinit var viewModel: MarketViewModel
    val plants = listOf(
        Plant("Tomato", R.drawable.tomato),
        Plant("Apple", R.drawable.apple),
        Plant("Sunflower", R.drawable.sunflower),
        Plant("Avocado", R.drawable.avocado),
        Plant("Beet", R.drawable.beet),
        Plant("eggplant", R.drawable.eggplant),
        Plant("Pear", R.drawable.pear)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = MarketFragmentBinding.inflate(inflater, container, false)
        val planListAdapter = MarketPlanListAdapter()
        planListAdapter.plants = plants
        binding.plantList.adapter = planListAdapter
        binding.plantList.layoutManager = GridLayoutManager(context, 2)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MarketViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val navController = NavHostFragment.findNavController(this@MarketFragment)
//        navController.navigate(R.id.gardenFragment)
    }

}
