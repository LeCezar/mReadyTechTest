package com.lecezar.mreadytechtest.listScreen

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lecezar.hotelupgrade.utils.base.BaseAdapter
import com.lecezar.mreadytechtest.R
import com.lecezar.mreadytechtest.databinding.GitRepoItemBinding
import com.lecezar.mreadytechtest.domains.GitRepoDto

class ReposAdapter(private val onClickItem: (item: GitRepoDto) -> Unit) : BaseAdapter<GitRepoDto, GitRepoItemBinding>(
    R.layout.item_git_repo,
    DIFF_CALLBACK
) {
    override fun bind(binding: GitRepoItemBinding, item: GitRepoDto, holder: BaseViewHolder<GitRepoItemBinding>) {
        binding.itemRepoRoot.setOnClickListener { onClickItem.invoke(item) }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GitRepoDto>() {
            override fun areItemsTheSame(oldItem: GitRepoDto, newItem: GitRepoDto): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: GitRepoDto, newItem: GitRepoDto): Boolean = oldItem == newItem
        }
    }
}

class EndlessScrolling(private val linearLayoutManager: LinearLayoutManager, private val loadMoreOnScrollCallback: () -> Unit) :
    RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (linearLayoutManager.itemCount > 0 &&
            this.linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.itemCount - 1
        )
            loadMoreOnScrollCallback.invoke()

    }

}