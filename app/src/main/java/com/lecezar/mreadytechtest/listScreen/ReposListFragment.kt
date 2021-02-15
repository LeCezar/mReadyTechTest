package com.lecezar.mreadytechtest.listScreen

import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lecezar.hotelupgrade.utils.base.BaseFragment
import com.lecezar.mreadytechtest.R
import com.lecezar.mreadytechtest.databinding.ReposFragmentBinding
import com.lecezar.mreadytechtest.domains.GitRepoDto
import org.koin.androidx.viewmodel.ext.android.viewModel


class ReposListFragment : BaseFragment<ReposFragmentBinding, ReposListFragmentVM>(R.layout.fragment_repos_list) {
    override val viewModel: ReposListFragmentVM by viewModel()

    override fun setupViews() {
        setUpRecyclerView()
        viewModel.getGitReposListLiveData().observe(viewLifecycleOwner, {
            submitListToRecyclerView(it)
        })
    }

    private fun setUpRecyclerView() {
        binding?.fragmentRepoListRecyclerView?.apply {
            adapter = ReposAdapter {
                view?.findNavController()?.navigate(ReposListFragmentDirections.actionReposListFragmentToDetailsRepoFragment(it))
            }
            layoutManager = LinearLayoutManager(this@ReposListFragment.context).also {
                addOnScrollListener(EndlessScrolling(it) {
                    viewModel.fetchGitReposNextPage()
                })
            }
        }
    }

    private fun submitListToRecyclerView(list: List<GitRepoDto>) {
        (binding?.fragmentRepoListRecyclerView?.adapter as ReposAdapter).submitList(list)
    }
}