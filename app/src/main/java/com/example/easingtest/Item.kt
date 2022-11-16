package com.example.easingtest

import com.example.easingtest.databinding.ItemBinding
import com.xwray.groupie.databinding.BindableItem


data class Item(
    private val imageRes: Int
) : BindableItem<ItemBinding>() {
    override fun bind(binding: ItemBinding, p1: Int) {
        binding.image.setImageResource(imageRes)
    }

    override fun getLayout(): Int = R.layout.item
}
