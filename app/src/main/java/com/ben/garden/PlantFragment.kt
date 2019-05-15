package com.ben.garden


import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ben.garden.data.Plant
import com.ben.garden.databinding.PlantFragmentBinding
import com.ben.garden.model.GardenViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.plant_fragment.view.*

/**
 * 植物详情页
 *
 */
class PlantFragment : Fragment(), View.OnClickListener {
    private lateinit var plant: Plant
    private val arg: PlantFragmentArgs by navArgs()
    private lateinit var viewModel: GardenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this.activity!!).get(GardenViewModel::class.java)
        val binding = PlantFragmentBinding.inflate(inflater, container, false)
        plant = arg.plant
        binding.plant = plant
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(plant.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view.plant_img)
        view.fab.setOnClickListener(this)
        if (viewModel.isHadBuy(plant)) {
            view.fab.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
        }
        view.plant_detail.text = HtmlCompat.fromHtml(plant.description, HtmlCompat.FROM_HTML_MODE_COMPACT)
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