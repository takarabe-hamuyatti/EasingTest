package com.example.easingtest

import android.content.Context
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class EasingScroller(
    context: Context,
    private val durationOnFindTarget: Int = 550,
) : LinearSmoothScroller(context) {

    override fun onTargetFound(targetView: View, state: RecyclerView.State, action: Action) {
        if (durationOnFindTarget <= 0) return
        val dy = calculateDyToMakeVisible(targetView, verticalSnapPreference)
        action.update(0, -dy, durationOnFindTarget, DecelerateInterpolator())
    }
}