package com.example.oollan.mvvmdatabinding

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class LoginViewModel(
    private val context: Context,
    private val user: User
) : BaseObservable() {

    @Bindable
    var toastMessage: String? = null

    private fun setToastMessage(id: Int) {
        toastMessage = context.getString(id)
        notifyPropertyChanged(BR.toastMessage)
    }

    fun afterEmailTextChanged(s: CharSequence) {
        user.email = s.toString()
    }

    fun afterPasswordTextChanged(s: CharSequence) {
        user.password = s.toString()
    }

    fun onLoginClicked() {
        if (user.isInputDataValid()) {
            setToastMessage(R.string.successMessage)
        } else {
            setToastMessage(R.string.errorMessage)
        }
    }
}