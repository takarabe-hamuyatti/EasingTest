package com.example.easingtest

import com.xwray.groupie.GroupieAdapter

class Adapter : GroupieAdapter() {
    fun showList() {
        update(
            buildList
            {
                itemList.forEach {
                    add(Item(it))
                }
                itemList.forEach {
                    add(Item(it))
                }
            }
        )
    }

    private val itemList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6
    )
}