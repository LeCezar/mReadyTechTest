package com.lecezar.mreadytechtest.detailsScreen

import androidx.navigation.fragment.navArgs
import com.lecezar.hotelupgrade.utils.base.BaseFragment
import com.lecezar.mreadytechtest.R
import com.lecezar.mreadytechtest.databinding.DetailsRepoFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsRepoFragment : BaseFragment<DetailsRepoFragmentBinding, DetailsRepoFragmentVM>(R.layout.fragment_details_repo) {


    override val viewModel: DetailsRepoFragmentVM by viewModel()
    private val args: DetailsRepoFragmentArgs by navArgs()

    override fun setupViews() {
        args.GitRepoDto.apply {
            setReadMeText()
            viewModel.init(this)
            viewModel.fetchReadMe(this.owner.userName, this.name).observe(viewLifecycleOwner, {
                if (!it.isNullOrEmpty())
                    setReadMeText(it)
            })
        }
    }

    private fun setReadMeText(text: String = "") {
        if (text.isEmpty())
            binding?.detailsRepoMarkdownView?.setMarkDownText(getString(R.string.fetching_markdown))
        else {
            binding?.detailsRepoMarkdownView?.setMarkDownText(text)
        }
    }
}