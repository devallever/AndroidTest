package com.example.androidunittest

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class GradientLinearLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        background = GradientBackgroundDrawable().apply {
            setColorList(mColorList, w.toFloat(), h.toFloat())
        }
    }

    private var mColorList = mutableListOf<String>()
    fun setColorList(color: List<String>) {
        mColorList.clear()
        mColorList.addAll(color)
    }
}