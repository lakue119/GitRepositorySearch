package com.lakue.gitrepositorysearch.remote.model.base

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil

/**
 * Created by leekijung on 2020. 1. 28..
 */

abstract class Model{

    abstract var id: Long
    abstract var type: CellType

    abstract fun getType1(): CellType

}

