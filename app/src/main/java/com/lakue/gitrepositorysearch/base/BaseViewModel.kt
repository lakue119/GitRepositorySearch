package com.lakue.gitrepositorysearch.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lakue.gitrepositorysearch.R
import com.lakue.gitrepositorysearch.remote.network.ResultWrapper
import com.lakue.gitrepositorysearch.utils.BaseUtils.context
import com.lakue.gitrepositorysearch.utils.EventLiveData

open class BaseViewModel : ViewModel() {

    protected val _liveNewWorkErrorDialog = MutableLiveData("")
    val liveNewWorkErrorDialog: LiveData<String> get() = _liveNewWorkErrorDialog

    protected val _liveSuccess = MutableLiveData<Any>()
    val liveSuccess: LiveData<Any> get() = _liveSuccess

    protected val _liveError = MutableLiveData<Any?>()
    val liveError: LiveData<Any?> get() = _liveError

    val liveToast = EventLiveData<CharSequence>()


    fun showToast(message: CharSequence) {
        liveToast.setEventValue(message)
    }

    fun resetValue(){
        _liveNewWorkErrorDialog.postValue(null)
        _liveSuccess.postValue(null)
        _liveError.postValue(null)
    }

    fun responseValidation(response: Any): Boolean{
        when(response){
            is ResultWrapper.NetworkError -> {
                _liveNewWorkErrorDialog.postValue(context.getString(R.string.dialog_network_error))
            }
            is ResultWrapper.Success<*> -> {
                _liveSuccess.postValue(response.value)
                return true
            }
            is ResultWrapper.TimeOutError -> {
                _liveNewWorkErrorDialog.postValue(context.getString(R.string.dialog_timeout_error))
            }
            is ResultWrapper.ServerError -> {
                _liveNewWorkErrorDialog.postValue(context.getString(R.string.dialog_server_error))
            }
            is ResultWrapper.GenericError -> {
                if (response.error == null) {
                    _liveNewWorkErrorDialog.postValue(context.getString(R.string.dialog_server_error))
                } else {
                    _liveError.postValue(response.error)
                }
            }
        }

        return false
    }

}