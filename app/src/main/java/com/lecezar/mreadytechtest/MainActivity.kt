package com.lecezar.mreadytechtest

import android.util.Log
import com.lecezar.hotelupgrade.utils.base.BaseActivity
import com.lecezar.mreadytechtest.databinding.MainActivityBinding
import com.lecezar.mreadytechtest.reposNetworking.NetworkManager
import com.lecezar.mreadytechtest.utils.helpers.executeRequest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityBinding, MainActivityVM>(R.layout.activity_main) {

    override val viewModel: MainActivityVM by viewModel()

    override fun setupViews() {

    }
}