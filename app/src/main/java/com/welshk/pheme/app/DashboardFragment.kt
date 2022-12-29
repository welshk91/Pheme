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
import com.welshk.pheme.model.Article
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
                setArticles(news.articles)
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
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.news.value?.let {
            setArticles(it.articles)
        }
    }

    private fun setArticles(articles: ArrayList<Article>){
        binding.newsArticles.adapter = DashboardAdapter(requireContext(), articles) {
            val bundle = Bundle()
            bundle.putParcelable(Constants.INTENT_KEY_ARTICLE, it)
            findNavController().navigate(R.id.action_dashboard_to_details, bundle)
        }
    }
}