package com.example.oollan.mvvmdatabinding

import android.text.TextUtils
import android.util.Patterns

data class User(
    var email: String = "",
    var password: String = ""
) {
    fun isInputDataValid(): Boolean {
        return !TextUtils.isEmpty(email) &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.length > 5
    }
}