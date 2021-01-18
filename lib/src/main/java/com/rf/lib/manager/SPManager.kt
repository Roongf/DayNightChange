package com.rf.lib.manager

import android.content.Context
import com.rf.lib.Constant

/**
 * Created by Roongf on 1/15/21
 */
object SPManager {
    fun getInt(context: Context, key: String, defaultValue: Int): Int {
        return context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.getInt(key, defaultValue) ?: defaultValue
    }

    fun putInt(context: Context, key: String, value: Int) {
        context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.edit()?.let { editor ->
            editor.putInt(key, value)
            editor.commit()
        }
    }

    fun getLong(context: Context, key: String, defaultValue: Long): Long {
        return context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.getLong(key, defaultValue) ?: defaultValue
    }

    fun putLong(context: Context, key: String, value: Long) {
        context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.edit()?.let { editor ->
            editor.putLong(key, value)
            editor.commit()
        }
    }

    fun getFloat(context: Context, key: String, defaultValue: Float): Float {
        return context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.getFloat(key, defaultValue) ?: defaultValue
    }

    fun putFloat(context: Context, key: String, value: Float) {
        context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.edit()?.let { editor ->
            editor.putFloat(key, value)
            editor.commit()
        }
    }

    fun getBoolean(context: Context, key: String, defaultValue: Boolean): Boolean {
        return context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.getBoolean(key, defaultValue) ?: defaultValue
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.edit()?.let { editor ->
            editor.putBoolean(key, value)
            editor.commit()
        }
    }

    fun getString(context: Context, key: String, defaultValue: String): String {
        return context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.getString(key, defaultValue) ?: defaultValue
    }

    fun putString(context: Context, key: String, value: String) {
        context.applicationContext.getSharedPreferences(
            Constant.APP_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )?.edit()?.let { editor ->
            editor.putString(key, value)
            editor.commit()
        }
    }


}