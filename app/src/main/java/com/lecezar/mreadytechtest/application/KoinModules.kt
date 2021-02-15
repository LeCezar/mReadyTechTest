package com.lecezar.hotelupgrade.application

import com.lecezar.mreadytechtest.MainActivityVM
import com.lecezar.mreadytechtest.detailsScreen.DetailsRepoFragmentVM
import com.lecezar.mreadytechtest.listScreen.ReposListFragmentVM
import com.lecezar.mreadytechtest.reposNetworking.NetworkManager
import com.lecezar.mreadytechtest.repositories.GitRepoRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModules {
    private val viewModels = module {
        viewModel { MainActivityVM() }
        viewModel { ReposListFragmentVM() }
        viewModel { DetailsRepoFragmentVM() }
    }

    private val apiModule = module {
        single { NetworkManager() }
    }

    private val repoModule = module {
        single { GitRepoRepository(get()) }
    }

    val modules = listOf(viewModels, apiModule, repoModule)
}