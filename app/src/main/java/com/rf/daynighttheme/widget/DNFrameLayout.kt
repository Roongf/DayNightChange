package com.rf.daynighttheme.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.rf.lib.base.BaseDayNightAttributeHolder
import com.rf.lib.IDayNightSwitcher

/**
 * Created by Roongf on 1/15/21
 */
class DNFrameLayout : FrameLayout, IDayNightSwitcher {

    private val mHolder by lazy {
        BaseDayNightAttributeHolder(this)
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttribute(attrs)
    }

    private fun initAttribute(attrs: AttributeSet?) {
        mHolder.initAttribute(attrs)
    }

    override fun resetDayNightThemeStyle() {
        mHolder.dayNightChangeBackground()
    }
}