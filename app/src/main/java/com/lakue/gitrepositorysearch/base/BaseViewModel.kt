package com.lakue.gitrepositorysearch.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakue.gitrepositorysearch.utils.EventLiveData

open class BaseViewModel : ViewModel() {

    private val _liveLoading = MutableLiveData(false)
    val liveLoading: LiveData<Boolean> get() = _liveLoading

    protected val _liveNewWorkErrorDialog = MutableLiveData("")
    val liveNewWorkErrorDialog: LiveData<String> get() = _liveNewWorkErrorDialog

    protected val _liveSuccess = MutableLiveData<Any>()
    val liveSuccess: LiveData<Any> get() = _liveSuccess

    protected val _liveError = MutableLiveData<Any?>()
    val liveError: LiveData<Any?> get() = _liveError

    val liveToast = EventLiveData<CharSequence>()

    fun showLoading() {
        _liveLoading.value = true
    }

    fun hideLoading() {
        _liveLoading.value = false
    }

    fun showToast(message: CharSequence) {
        liveToast.setEventValue(message)
    }

    fun resetValue(){
        _liveLoading.postValue(null)
        _liveNewWorkErrorDialog.postValue(null)
        _liveSuccess.postValue(null)
        _liveError.postValue(null)
    }

}