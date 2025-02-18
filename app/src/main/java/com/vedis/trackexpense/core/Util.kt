package com.vedis.trackexpense.core

fun Double.toCurrency(): String {
    return "$${this}"
}