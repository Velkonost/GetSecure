package com.get.secure.webview.interpolator

import android.view.animation.Interpolator
import androidx.core.view.animation.PathInterpolatorCompat

/**
 * Bezier decelerate curve similar to iOS.
 * On Kitkat and below, it reverts to a
 * decelerate interpolator.
 */
class BezierDecelerateInterpolator : Interpolator {

    companion object {
        private val PATH_INTERPOLATOR: Interpolator = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1f)
    }

    override fun getInterpolation(input: Float): Float = PATH_INTERPOLATOR.getInterpolation(input)

}
