package com.hyun.android.interpolatorsample

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.animation.*
import kotlinx.android.synthetic.main.dialog_interpolator_compare.*

class InterpolatorCompareDialog(
    var activity: Activity
) : Dialog(activity) {
    var TAG = javaClass.simpleName
    var ANI_DURATION = 1500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_interpolator_compare)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btn_start.setOnClickListener { init() }
        startAnimation()
    }

    private fun startAnimation() {
        var dp = activity.resources.displayMetrics.density

        btn_AccelerateDecelerate.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(AccelerateDecelerateInterpolator()).start()

        btn_Accelerate.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(AccelerateInterpolator()).start()

        btn_Anticipate.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(AnticipateInterpolator()).start()

        btn_Overshoot.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(OvershootInterpolator()).start()

        btn_Bounce.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(BounceInterpolator()).start()

        btn_Cycle.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(CycleInterpolator(0.5f)).start()

        btn_Decelerate.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(DecelerateInterpolator()).start()

        btn_Linear.animate().translationX(260 * dp).setDuration(ANI_DURATION)
            .setInterpolator(LinearInterpolator()).start()
    }

    private fun init() {
        btn_AccelerateDecelerate.apply { translationX = 0f }
        btn_Accelerate.apply { translationX = 0f }
        btn_Anticipate.apply { translationX = 0f }
        btn_Overshoot.apply { translationX = 0f }
        btn_Bounce.apply { translationX = 0f }
        btn_Cycle.apply { translationX = 0f }
        btn_Decelerate.apply { translationX = 0f }
        btn_Linear.apply { translationX = 0f }
        btn_Overshoot.apply { translationX = 0f }

        startAnimation()
    }

}