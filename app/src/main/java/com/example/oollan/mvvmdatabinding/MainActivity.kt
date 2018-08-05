package com.example.oollan.mvvmdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil.setContentView
import com.example.oollan.mvvmdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = LoginViewModel(this, User())
        activityMainBinding.executePendingBindings()
    }

    object BindingAdapters {
        @JvmStatic
        @BindingAdapter("toastMessage")
        fun toastMessage(view: View, message: String?) {
            if (message != null)
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}