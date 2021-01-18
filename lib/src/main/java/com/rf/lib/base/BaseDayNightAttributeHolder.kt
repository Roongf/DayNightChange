package com.rf.lib.base

import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.rf.lib.R

/**
 * Created by Roongf on 1/15/21
 */
class BaseDayNightAttributeHolder(private val dayNightView: View) {
    private var backgroundResourceID = -1
    private var textColorResourceID = -1
    private var srcResourceID = -1

    fun initAttribute(attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = dayNightView.context?.obtainStyledAttributes(attrs, R.styleable.DayNightView)
            backgroundResourceID = typedArray?.getResourceId(R.styleable.DayNightView_android_background, View.NO_ID) ?: -1
            textColorResourceID = typedArray?.getResourceId(R.styleable.DayNightView_android_textColor, View.NO_ID) ?: -1
            srcResourceID = typedArray?.getResourceId(R.styleable.DayNightView_android_src, View.NO_ID) ?: -1
            typedArray?.recycle()
        }
    }

    /**
     * change day-night View's background
     */
    fun dayNightChangeBackground() {
        try {
            dayNightView.background = ContextCompat.getDrawable(dayNightView.context, backgroundResourceID)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * change day-night TextView's TextColor
     */
    fun dayNightChangeTextColor() {
        try {
            if (dayNightView is TextView) {
                dayNightView.setTextColor(ContextCompat.getColor(dayNightView.context, textColorResourceID))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * change day-night ImageView's ImageResource
     */
    fun dayNightChangeSrc() {
        try {
            if (dayNightView is AppCompatImageView) {
                dayNightView.setImageResource(srcResourceID)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}