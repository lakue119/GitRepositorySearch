package com.lakue.gitrepositorysearch.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lakue.gitrepositorysearch.base.BaseAdapter
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.base.Model
import com.lakue.gitrepositorysearch.utils.provider.DefaultResourcesProvider
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider

/**
 * RecyclerView Adapter
 */
@BindingAdapter(value = ["lakue_item", "lakue_viewModel", "lakue_resProvider", "lakue_listsner"])
fun RecyclerView.setBindItem(
    modelList: List<Model>? = null,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider = DefaultResourcesProvider(
        context
    ),
    adapterListener: AdapterListener
) {
    var adapter: BaseAdapter<Model, BaseViewModel>? = null

    setHasFixedSize(true)
    if(this.adapter == null){
        adapter = modelList?.let {
            BaseAdapter(
                it,
                viewModel, resourcesProvider, adapterListener)
        }
        setAdapter(adapter)
    } else {
        modelList?.let{
            (this.adapter as BaseAdapter<*, *>).submitList(it)
//            (this.adapter as BaseAdapter<*, *>).notifyDataSetChanged()
        }
    }

}

@BindingAdapter("onBottomCatchEvent")
fun RecyclerView.onBottomCatchEvent(f: Function1<Int, Unit>?) {

    if (f == null) //addOnScrollListener(null)
    else addOnScrollListener(object :RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
            f(lastVisibleItemPosition)
        }
    })
}