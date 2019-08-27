package com.ben.garden.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textSize")
fun updateTextSize(view: TextView, size: Int) {
    view.textSize = size.toFloat()

}