package com.lakue.gitrepositorysearch.ui.main

import android.os.Bundle
import android.util.Log
import com.lakue.gitrepositorysearch.R
import com.lakue.gitrepositorysearch.base.BaseActivity
import com.lakue.gitrepositorysearch.databinding.ActivityMainBinding
import com.lakue.gitrepositorysearch.ext.logI
import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main){
    val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchGitRepository("android")

        setObserver()
    }

    private fun setObserver(){
        viewModel.apply{
            liveSuccess.observe(this@MainActivity){ response ->
                val data = response as ResponseGitRepository
                logI(TAG, data.toString())
            }
        }
    }
}