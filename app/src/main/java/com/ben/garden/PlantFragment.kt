package com.ben.garden


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ben.garden.data.Plant
import com.ben.garden.databinding.PlantFragmentBinding
import kotlinx.android.synthetic.main.plant_fragment.view.*

/**
 * 植物详情页
 *
 */
class PlantFragment : Fragment(), View.OnClickListener {
    private lateinit var plant: Plant
    private val arg: PlantFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = PlantFragmentBinding.inflate(inflater, container, false)
        Log.i("JKL", "onCreateView: ${arg.plant}")
        plant = arg.plant
        binding.plant = plant
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.plant_img.setImageResource(plant.imgId)
        view.fab.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.fab -> {
                val bundle = GardenFragmentArgs(plant)
                findNavController().navigate(R.id.action_plantFragment_to_gardenFragment, bundle.toBundle())
            }
        }
    }


}
