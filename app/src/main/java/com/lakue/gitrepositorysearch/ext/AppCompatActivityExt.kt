package com.lakue.gitrepositorysearch.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

fun AppCompatActivity.showToast(msg: CharSequence, isLong: Boolean = false) {
    Toast.makeText(
        applicationContext,
        msg,
        if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    )
        .show()
}

fun AppCompatActivity.showToast(msgId: Int, isLong: Boolean = false) {
    showToast(getString(msgId), isLong)
}
