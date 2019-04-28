package com.ben.garden


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ben.garden.data.Plant
import com.ben.garden.databinding.PlantFragmentBinding
import kotlinx.android.synthetic.main.plant_fragment.view.*

/**
 * 植物详情页
 *
 */
class PlantFragment : Fragment() {
    private var plant :Plant? = null
    private val arg : PlantFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = PlantFragmentBinding.inflate(inflater, container, false)
        Log.i("JKL", "onCreateView: ${arg.plant}")
        plant = arg.plant
        binding.plant = plant
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.plant_fragment_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (plant != null) {
            view.plant_img.setImageResource(plant!!.imgId)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
             R.id.action_select-> {
                 if (plant != null && view != null) {
                     val bundle = GardenFragmentArgs(plant!!)
                     findNavController().navigate(R.id.action_plantFragment_to_gardenFragment, bundle.toBundle())
                 }
                 return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
