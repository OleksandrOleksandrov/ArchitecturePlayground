package com.oleksandr.presentation.core.platform.base.ext

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
//import kotlin.reflect.full.memberProperties

/**
 * Extension function to retrieve a Parcelable from an Intent.
 *
 * @param T The type of the Parcelable.
 * @param key The key for the Parcelable extra.
 * @return The Parcelable extra or null if not found.
 *
 * Usage:
 *
 * ```kotlin
 * val myParcelable: MyParcelable? = intent.parcelable("my_key")
 * ```
 */
// TODO: test
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? =
    when {
        SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableExtra(key, T::class.java)
        else ->
            @Suppress("DEPRECATION")
            getParcelableExtra(key)
                as? T
    }

/**
 * Extension function to retrieve a Parcelable from a Bundle.
 *
 * @param T The type of the Parcelable.
 * @param key The key for the Parcelable.
 * @return The Parcelable or null if not found.
 *
 * Usage:
 *
 * ```kotlin
 * val myParcelable: MyParcelable? = bundle.parcelable("my_key")
 * ```
 */
// TODO: test
inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? =
    when {
        SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelable(key, T::class.java)
        else ->
            @Suppress("DEPRECATION")
            getParcelable(key)
                as? T
    }

/**
 * Extension function to retrieve a list of Parcelable objects from a Bundle.
 *
 * @param T The type of the Parcelable.
 * @param key The key for the Parcelable ArrayList.
 * @return The Parcelable ArrayList or null if not found.
 *
 * Usage:
 *
 * ```kotlin
 * val myParcelableList: ArrayList<MyParcelable>? = bundle.parcelableArrayList("my_key")
 * ```
 */
// TODO: test
inline fun <reified T : Parcelable> Bundle.parcelableArrayList(key: String): ArrayList<T>? =
    when {
        SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableArrayList(key, T::class.java)
        else ->
            @Suppress("DEPRECATION")
            getParcelableArrayList(key)
    }

/**
 * Extension function to retrieve a list of Parcelable objects from an Intent.
 *
 * @param T The type of the Parcelable.
 * @param key The key for the Parcelable ArrayList extra.
 * @return The Parcelable ArrayList extra or null if not found.
 *
 * Usage:
 *
 * ```kotlin
 * val myParcelableList: ArrayList<MyParcelable>? = intent.parcelableArrayList("my_key")
 * ```
 */
// TODO: test
inline fun <reified T : Parcelable> Intent.parcelableArrayList(key: String): ArrayList<T>? =
    when {
        SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableArrayListExtra(key, T::class.java)
        else ->
            @Suppress("DEPRECATION")
            getParcelableArrayListExtra(key)
    }

/**
 * Extension function to convert a Parcelable object into a Map of its properties.
 *
 * @param T The type of the Parcelable.
 * @return A Map where the keys are property names and values are the corresponding property values.
 *
 * This function uses reflection to iterate over all properties of the Parcelable object and
 * creates a Map containing property names as keys and their current values as the Map's values.
 *
 * Usage:
 *
 * ```kotlin
 * @Parcelize
 * data class MyParcelable(val id: Int, val name: String) : Parcelable
 *
 * val myParcelable = MyParcelable(1, "Example")
 * val mapRepresentation = myParcelable.toMap() // {id=1, name=Example}
 * ```
 */
//inline fun <reified T : Parcelable> T.toMap(): Map<String, Any?> = T::class.memberProperties.associate { it.name to it.get(this) }
