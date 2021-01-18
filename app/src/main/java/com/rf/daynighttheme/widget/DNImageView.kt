package com.rf.daynighttheme.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.rf.lib.base.BaseDayNightAttributeHolder
import com.rf.lib.IDayNightSwitcher

/**
 * Created by Roongf on 1/18/21
 */
class DNImageView : AppCompatImageView, IDayNightSwitcher {
    private val mHolder by lazy {
        BaseDayNightAttributeHolder(this)
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        mHolder.initAttribute(attrs)
    }

    override fun resetDayNightThemeStyle() {
        mHolder.dayNightChangeBackground()
        mHolder.dayNightChangeSrc()
    }
}