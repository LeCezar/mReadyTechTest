package com.lecezar.mreadytechtest.detailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lecezar.mreadytechtest.domains.GitRepoDto
import com.lecezar.mreadytechtest.repositories.GitRepoRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsRepoFragmentVM : ViewModel(), KoinComponent {

    lateinit var gitRepoDto: GitRepoDto
    private val gitRepoRepository: GitRepoRepository by inject()

    fun init(gitRepoDto: GitRepoDto) {
        this.gitRepoDto = gitRepoDto
    }

    fun fetchReadMe(repoOwner: String, repo: String): LiveData<String> = gitRepoRepository.getGitRepoReadMe(repoOwner, repo)

}