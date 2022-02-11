package com.lakue.gitrepositorysearch

import android.app.Application
import android.os.Build
import android.webkit.WebView
import com.lakue.gitrepositorysearch.utils.BaseUtils.init
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GRSApplication: Application(){

    companion object{
        lateinit var OTTApplication: GRSApplication

        fun getInstance(): GRSApplication{
            return OTTApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        OTTApplication = this
        init(this)
    }
}