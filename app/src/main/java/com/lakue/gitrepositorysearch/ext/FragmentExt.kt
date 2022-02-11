package com.lakue.gitrepositorysearch.ext

import androidx.fragment.app.Fragment
import com.lakue.gitrepositorysearch.base.BaseActivity

fun Fragment.showToast(msg: CharSequence, isLong: Boolean = false) {
    (activity as? BaseActivity<*, *>)?.showToast(msg, isLong)
}

fun Fragment.showToast(msgId: Int, isLong: Boolean = false) {
    (activity as? BaseActivity<*, *>)?.showToast(msgId, isLong)
}