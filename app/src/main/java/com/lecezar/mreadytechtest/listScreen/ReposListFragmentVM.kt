package com.lecezar.mreadytechtest.listScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lecezar.mreadytechtest.domains.GitRepoDto
import com.lecezar.mreadytechtest.repositories.GitRepoRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ReposListFragmentVM : ViewModel(), KoinComponent {

    private val gitRepoRepository: GitRepoRepository by inject()
    private val gitReposList: LiveData<List<GitRepoDto>> by lazy {
        gitRepoRepository.getGitReposLiveData()
    }

    init {
        fetchGitReposFirstPage()
    }

    fun fetchGitReposFirstPage() = gitRepoRepository.fetchGitReposFirstPage()
    fun fetchGitReposNextPage() = gitRepoRepository.nextGitReposPage()
    fun getGitReposListLiveData(): LiveData<List<GitRepoDto>> = gitReposList

}