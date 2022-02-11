package com.lakue.gitrepositorysearch.remote.model

import com.google.gson.annotations.SerializedName
import com.lakue.gitrepositorysearch.remote.model.base.CellType
import com.lakue.gitrepositorysearch.remote.model.base.License
import com.lakue.gitrepositorysearch.remote.model.base.Model

data class Item(
    @SerializedName("description") val description: String = "",
    @SerializedName("full_name") val full_name: String = "",
    @SerializedName("id") override var id: Long = 0,
    @SerializedName("watchers") val watchers: String = "",
    @SerializedName("forks_count") val forks_count: String = "",
    override var type: CellType = CellType.GIT_REPOSITORY_CELL
): Model() {
    override fun getType1(): CellType {
        return type ?: CellType.GIT_REPOSITORY_CELL
    }
}