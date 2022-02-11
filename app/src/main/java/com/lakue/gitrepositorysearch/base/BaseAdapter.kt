package com.lakue.gitrepositorysearch.base

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.base.CellType
import com.lakue.gitrepositorysearch.remote.model.base.Model
import com.lakue.gitrepositorysearch.utils.BaseUtils.context
import com.lakue.gitrepositorysearch.utils.Diff
import com.lakue.gitrepositorysearch.utils.mapper.ModelViewHolderMapper
import com.lakue.gitrepositorysearch.utils.provider.DefaultResourcesProvider
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider

class BaseAdapter<M: Model, VM: BaseViewModel>(
    private var modelList: List<Model>,
    private var viewModel: VM,
    private val resourcesProvider: ResourcesProvider = DefaultResourcesProvider(context),
    private val adapterListener: AdapterListener
) : RecyclerView.Adapter<BaseViewHolder<M>>() {

    val items = ArrayList<M>()

    fun addItem(item: M){
        val startCount = this.items.size

        this.items.add(item)
        notifyItemRangeInserted(startCount, startCount+1)
    }

    fun addItem(items: List<M>){
        val startCount = this.items.size
        val endCount = startCount + items.size

        this.items.addAll(items)
        notifyItemRangeInserted(startCount, endCount)
    }

    fun clear(){
        this.items.clear()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int): Int{
        return modelList[position].getType1().ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M> {
        return ModelViewHolderMapper.map(parent, CellType.values()[viewType], viewModel, resourcesProvider)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) {
        with(holder) {
            bindData(modelList[position] as M)
            bindViews(modelList[position] as M, adapterListener)
        }
    }
}