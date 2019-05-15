package com.ben.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.ben.garden.adapter.MarketPlanListAdapter
import com.ben.garden.databinding.MarketFragmentBinding
import com.ben.garden.model.MarketViewModel


class MarketFragment : Fragment() {
    private lateinit var viewModel: MarketViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = MarketFragmentBinding.inflate(inflater, container, false)
        val planListAdapter = MarketPlanListAdapter()
        viewModel = ViewModelProviders.of(this).get(MarketViewModel::class.java)
        binding.plantList.adapter = planListAdapter
        binding.plantList.layoutManager = GridLayoutManager(context, 2)
        viewModel.list.observe(this, Observer {
            planListAdapter.plants = it
            planListAdapter.notifyDataSetChanged()
        })
        return binding.root
    }
}
