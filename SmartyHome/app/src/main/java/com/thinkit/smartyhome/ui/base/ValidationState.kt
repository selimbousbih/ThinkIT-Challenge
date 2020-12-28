package com.thinkit.smartyhome.ui.base

sealed class ValidationState<TValue, TError> {
    class Pending<TValue, TError> : ValidationState<TValue, TError>()

    class Success<TValue, TError> internal constructor(val value: TValue) : ValidationState<TValue, TError>()

    class Error<TValue, TError> internal constructor(val error: TError) : ValidationState<TValue, TError>()
}