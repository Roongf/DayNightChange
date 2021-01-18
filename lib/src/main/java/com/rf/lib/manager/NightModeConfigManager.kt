package com.rf.lib.manager

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.forEach
import com.rf.lib.IDayNightSwitcher
import com.rf.lib.Constant

/**
 * Created by Roongf on 1/15/21
 */
class NightModeConfigManager {

    /**
     * check current application theme mode is night theme
     */
    fun isNightMode(): Boolean {
        checkContextNull()
        return SPManager.getBoolean(sContext!!, Constant.APP_THEME_DAY_NIGHT_MODE, false)
    }

    /**
     * init day night mode, call it on application first run
     */
    fun initDayNightMode() {
        val isNightMode = isNightMode()
        AppCompatDelegate.setDefaultNightMode(if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    /**
     * change application day-night theme mode
     */
    fun changeDayNightMode() {
        checkContextNull()
        val isNightMode = isNightMode()
        SPManager.putBoolean(sContext!!, Constant.APP_THEME_DAY_NIGHT_MODE, !isNightMode)
        AppCompatDelegate.setDefaultNightMode(if (!isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
    }

    /**
     * 切换日/夜间模式
     */
    @Synchronized
    fun dayNightChangeCurrentWindow(window: Window) {
        changeWindowUseAnimation(window)
        refreshDayNightView(window.decorView)
    }

    /**
     * refresh all need show day-night view
     */
    private fun refreshDayNightView(view: View) {
        if (view is IDayNightSwitcher) {
            view.resetDayNightThemeStyle()
        }

        if (view is ViewGroup) {
            view.forEach {
                refreshDayNightView(it)
            }
        }
    }

    /**
     * 当前页面直接切换日/夜间模式的动画
     */
    private fun changeWindowUseAnimation(window: Window) {
        val decorView: View = window.decorView
        val cacheBitmap = getRootCacheBitmap(decorView)
        if (decorView is ViewGroup && cacheBitmap != null) {
            val animView = View(window.context)
            animView.background = BitmapDrawable(animView.resources, cacheBitmap)
            decorView.addView(animView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            val dayNightAnimator = ObjectAnimator.ofFloat(animView, "alpha", 1f, 0f)
            dayNightAnimator.setDuration(500)
                .addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        decorView.removeView(animView)
                    }
                })
            dayNightAnimator.start()
        }
    }

    /**
     * 当前缓存视图用来做动画
     *
     * @param decorView
     * @return
     */
    private fun getRootCacheBitmap(decorView: View?): Bitmap? {
        var bitmap: Bitmap? = null
        if (decorView != null) {
            decorView.isDrawingCacheEnabled = true
            decorView.buildDrawingCache()
            val cacheBitmap = decorView.drawingCache
            if (cacheBitmap != null) {
                bitmap = Bitmap.createBitmap(cacheBitmap)
                decorView.isDrawingCacheEnabled = false
            }
        }
        return bitmap
    }

    private fun checkContextNull() {
        if (sContext == null) {
            throw NullPointerException("You must init context use #NightModeConfigManager.init(context) function")
        }
    }

    companion object {
        private var sContext: Context? = null

        val INSTANCE: NightModeConfigManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            NightModeConfigManager()
        }

        fun init(context: Context) {
            this.sContext = context.applicationContext
        }
    }
}