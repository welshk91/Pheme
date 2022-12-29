package com.welshk.pheme.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.welshk.pheme.R
import com.welshk.pheme.databinding.FragmentDashboardBinding
import com.welshk.pheme.utils.Constants
import com.welshk.pheme.views.ArticleItemDecoration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.news.observe(this) { news ->
            context?.let {
                binding.progressbar.visibility = View.GONE
                binding.newsArticles.addItemDecoration(
                    ArticleItemDecoration(
                        marginTopBottom = resources.getDimensionPixelSize(
                            R.dimen.dashboardArticleMarginTopBottom
                        ),
                        marginSide = resources.getDimensionPixelSize(
                            R.dimen.dashboardArticleMarginSide
                        )
                    )
                )
                binding.newsArticles.adapter = DashboardAdapter(requireContext(), news.articles){
                    val bundle = Bundle()
                    bundle.putParcelable(Constants.INTENT_KEY_ARTICLE, it)
                    findNavController().navigate(R.id.action_dashboard_to_details, bundle)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}