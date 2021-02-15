package com.lecezar.mreadytechtest.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lecezar.mreadytechtest.domains.GitRepoDto
import com.lecezar.mreadytechtest.reposNetworking.GitReposReadMeService
import com.lecezar.mreadytechtest.reposNetworking.GitReposService
import com.lecezar.mreadytechtest.reposNetworking.NetworkManager
import com.lecezar.mreadytechtest.utils.helpers.executeRequest

class GitRepoRepository(private val networkManager: NetworkManager) {

    private val gitReposList = MutableLiveData<List<GitRepoDto>>(listOf())
    private var currentPage = 0

    fun fetchGitReposFirstPage() {
        currentPage = 1
        fetchGitReposPage(currentPage)
    }

    fun nextGitReposPage() {
        if (currentPage == 0)
            fetchGitReposFirstPage()
        else {
            fetchGitReposPage(++currentPage)
        }
    }

    private fun fetchGitReposPage(page: Int) {
        networkManager.gitReposService.getAllAndroidRepos(page).executeRequest(
            onSuccess = {
                if (page == 1) {
                    gitReposList.value = it.reposList
                } else {
                    gitReposList.value?.apply {
                        gitReposList.value = this + it.reposList
                    }
                }
            },
            onError = {
                Log.d("NETWORKING", "Error on first page fetch")
            }
        )
    }

    fun getGitRepoReadMe(repoOwner: String, repo: String): LiveData<String> =
        MutableLiveData<String>().apply {
            networkManager.gitReposReadMe.getReadMe(repoOwner, repo).executeRequest(
                onSuccess = {
                    this.value = it
                },
                onError = {
                    Log.d("NETWORKING", "?")
                }
            )
        }


    fun getGitReposLiveData(): LiveData<List<GitRepoDto>> = gitReposList

}