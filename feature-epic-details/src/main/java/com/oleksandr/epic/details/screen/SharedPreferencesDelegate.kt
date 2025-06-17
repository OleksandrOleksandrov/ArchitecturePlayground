package com.oleksandr.epic.details.screen

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Suppress("UNCHECKED_CAST")
inline fun <reified T> SharedPreferences.sharedPref(
    key: String,
    defaultValue: T,
): ReadWriteProperty<Any?, T> =
    when (T::class) {
        String::class -> SharedPreferencesDelegate(this, key, defaultValue as String)
        Int::class -> SharedPreferencesDelegate(this, key, defaultValue as Int)
        Boolean::class -> SharedPreferencesDelegate(this, key, defaultValue as Boolean)
        Float::class -> SharedPreferencesDelegate(this, key, defaultValue as Float)
        Long::class -> SharedPreferencesDelegate(this, key, defaultValue as Long)
        else -> throw IllegalArgumentException("Unsupported type")
    } as ReadWriteProperty<Any?, T>

@Suppress("UNCHECKED_CAST")
class SharedPreferencesDelegate<T>(
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defaultValue: T,
) : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (defaultValue) {
            is String -> sharedPreferences.getString(key, defaultValue) as T
            is Int -> sharedPreferences.getInt(key, defaultValue) as T
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue) as T
            is Float -> sharedPreferences.getFloat(key, defaultValue) as T
            is Long -> sharedPreferences.getLong(key, defaultValue) as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        with(sharedPreferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
            apply()
        }
    }
}