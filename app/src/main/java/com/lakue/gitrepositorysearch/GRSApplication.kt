package com.lakue.gitrepositorysearch

import android.app.Application
import android.os.Build
import android.webkit.WebView
import com.lakue.gitrepositorysearch.utils.BaseUtils.init
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GRSApplication: Application(){

    //왜 싱글톤 썻는지
    //stati과 차이점
    companion object{
        lateinit var GRSApplication: GRSApplication

        fun getInstance(): GRSApplication{
            return GRSApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        GRSApplication = this
        init(this)
    }
}