package com.hyun.android.interpolatorsample

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.animation.Interpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog_interpolator.*

class InterpolatorDialog(var activity: Activity, var interpolator: Interpolator, var title: String, var duration: String?) : Dialog(activity) {
    var TAG = javaClass.simpleName
    var ANI_DURATION = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_interpolator)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        if (duration == null || duration!!.isEmpty()) {
            ANI_DURATION = 1000L
        } else if (!isLong(duration)) {
            Toast.makeText(activity, "애니메이션 duraion값이 유효하지 않습니다.\n기본값으로 변경합니다.(1sec)", Toast.LENGTH_LONG).show()
        } else {
            ANI_DURATION = duration!!.toLong()
        }

        btn_start.setOnClickListener { init() }
        tv_title.text = title
        startAnimation()
    }

    private fun startAnimation() {
        var dp = activity.resources.displayMetrics.density
        btn_trans.animate().translationX(210 * dp).setDuration(ANI_DURATION).setInterpolator(interpolator).start()
        btn_sacle_up.animate().scaleY(1f).scaleX(1f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION).start()
        btn_sacle_down.animate().scaleY(0.1f).scaleX(0.1f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION).start()
        btn_alpha_up.animate().alpha(1f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION * 2).start()
        btn_alpha_down.animate().alpha(0.1f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION * 2).start()
        btn_rot_X.animate().rotationX(180f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION * 3).start()
        btn_rot_Y.animate().rotationY(180f).setDuration(ANI_DURATION).setInterpolator(interpolator).setStartDelay(ANI_DURATION * 3).start()
        btn_rot_XY.animate().rotationX(180f).rotationY(180f).setDuration(ANI_DURATION).setStartDelay(ANI_DURATION * 3).setInterpolator(interpolator).start()
    }

    private fun init() {
        btn_trans.apply { translationX = 0f }
        btn_sacle_up.apply { scaleX = 0.1f; scaleY = 0.1f }
        btn_sacle_down.apply { scaleX = 1f; scaleY = 1f }
        btn_alpha_up.apply { alpha = 0.1f }
        btn_alpha_down.apply { alpha = 1f }
        btn_rot_X.apply { rotationX = 0f }
        btn_rot_Y.apply { rotationY = 0f }
        btn_rot_XY.apply { rotationX = 0f; rotationY = 0f }

        startAnimation()
    }

}