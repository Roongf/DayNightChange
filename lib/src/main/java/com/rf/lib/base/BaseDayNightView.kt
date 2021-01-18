package com.rf.lib.base

import android.util.AttributeSet
import com.rf.lib.IDayNightSwitcher

/**
 * Created by Roongf on 1/18/21
 */
abstract class BaseDayNightView : IDayNightSwitcher {
    protected val mHolder: BaseDayNightAttributeHolder = getHolder()
    abstract fun getHolder(): BaseDayNightAttributeHolder
    private fun initAttribute(attrs: AttributeSet?) {
        mHolder.initAttribute(attrs)
    }
}