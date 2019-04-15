package com.hyun.android.interpolatorsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
    }

    private fun setView() {
        btn_AccelerateDecelerate.setOnClickListener { InterpolatorDialog(this, AccelerateDecelerateInterpolator(), "AccelerateDecelerateInterpolator", et_duration.text.toString()).show() }
        btn_Accelerate.setOnClickListener { InterpolatorDialog(this, AccelerateInterpolator(), "AccelerateInterpolator", et_duration.text.toString()).show() }
        btn_Anticipate.setOnClickListener { InterpolatorDialog(this, AnticipateInterpolator(), "AnticipateInterpolator", et_duration.text.toString()).show() }
        btn_AnticipateOvershoot.setOnClickListener { InterpolatorDialog(this, OvershootInterpolator(), "OvershootInterpolator", et_duration.text.toString()).show() }
        btn_Bounce.setOnClickListener { InterpolatorDialog(this, BounceInterpolator(), "BounceInterpolator", et_duration.text.toString()).show() }
        btn_Cycle.setOnClickListener { InterpolatorDialog(this, CycleInterpolator(0.5f), "CycleInterpolator", et_duration.text.toString()).show() }
        btn_Decelerate.setOnClickListener { InterpolatorDialog(this, DecelerateInterpolator(), "DecelerateInterpolator", et_duration.text.toString()).show() }
        btn_Linear.setOnClickListener { InterpolatorDialog(this, LinearInterpolator(), "LinearInterpolator", et_duration.text.toString()).show() }
        btn_Overshoot.setOnClickListener { InterpolatorDialog(this, OvershootInterpolator(), "OvershootInterpolator", et_duration.text.toString()).show() }
    }
}
