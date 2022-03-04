package com.example.anymindresume.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

interface ActionBarDynamicTitle {

    fun Activity?.setupTitle(title: String) {
        val activity = (this as? AppCompatActivity) ?: return
        activity.supportActionBar?.title = title
    }

}