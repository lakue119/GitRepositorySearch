package com.lakue.gitrepositorysearch.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.lakue.gitrepositorysearch.ext.logI
import com.lakue.gitrepositorysearch.remote.model.base.Model

//DiffUtil 공부.
object Diff: DiffUtil.ItemCallback<Model>() {

    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem == newItem
    }
}
