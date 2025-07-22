package com.oleksandr.presentation.core.platform.base.mvi

import android.os.Bundle

/**
 * An interface that converts a [MviViewState] to a [Bundle] and vice versa.
 */
interface MviViewStateSaver<S : MviViewState> {
    fun S.toBundle(): Bundle

    fun restore(bundle: Bundle?): S
}
