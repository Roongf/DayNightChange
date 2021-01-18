package com.rf.daynighttheme.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.rf.lib.IDayNightSwitcher
import com.rf.lib.base.BaseDayNightAttributeHolder

/**
 * Created by Roongf on 1/18/21
 */
class DNButton : AppCompatButton, IDayNightSwitcher {
    private val mHolder by lazy {
        BaseDayNightAttributeHolder(this)
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mHolder.initAttribute(attrs)
    }

    override fun resetDayNightThemeStyle() {
        mHolder.dayNightChangeBackground()
        mHolder.dayNightChangeTextColor()
    }

}