package com.example.easingtest

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class EaseOutScroller(
    context: Context,
    private val durationOnFindTarget: Int = 550,
) : LinearSmoothScroller(context) {

    companion object {
        private const val MILLISECONDS_PER_INCH = 10f // デフォルトの速さは25f ちょっと速くしてる
    }

    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi
    }

    override fun onTargetFound(targetView: View, state: RecyclerView.State, action: Action) {
        if (durationOnFindTarget <= 0) return
        val dy = calculateDyToMakeVisible(targetView, verticalSnapPreference)
        action.update(0, -dy, durationOnFindTarget, DecelerateInterpolator())
    }
}