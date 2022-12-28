package com.welshk.pheme.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.welshk.pheme.R
import com.welshk.pheme.databinding.FragmentDashboardBinding
import com.welshk.pheme.networking.ApplicationDataRepository
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        ApplicationDataRepository.getTopHeadlines(
            "Apple", "us", null, null,
            {
                Toast.makeText(
                    context,
                    "Found " + it.articles.size + " articles",
                    Toast.LENGTH_SHORT
                ).show()
            },
            {
                Toast.makeText(context, "Found " + it.message + " articles", Toast.LENGTH_LONG)
                    .show()
            }
        )
        return binding.root
    }
}