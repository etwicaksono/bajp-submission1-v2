package com.etwicaksono.infomovie2.ui.favoritelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.databinding.FragmentListBinding
import com.etwicaksono.infomovie2.ui.detail.DetailActivity
import com.etwicaksono.infomovie2.ui.homelist.FavoriteListAdapter
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory

class FavoriteListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: FavoriteListViewModel
    private lateinit var favoriteListAdapter: FavoriteListAdapter
    private lateinit var type: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString(TYPE)?.let { type = it }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(
                this,
                factory
            )[FavoriteListViewModel::class.java]

            favoriteListAdapter = FavoriteListAdapter {
                showSelectedData(it)
            }

            when (type) {
                Helper.TYPE_MOVIE -> {
                    viewModel.getFavoriteMovies().observe(viewLifecycleOwner) { listMovies ->
                        favoriteListAdapter.submitList(listMovies)
                        if (listMovies != null && !listMovies.isEmpty()) {
                            binding?.rvFilm?.adapter.let {
                                binding?.apply {
                                    progressBarWrapper.progressBar.visibility = View.GONE
                                    tvNoData.visibility = View.GONE
                                }
                            }
                        } else {
                            binding?.tvNoData?.visibility = View.VISIBLE
                        }
                    }
                }
                Helper.TYPE_TV -> {
                    viewModel.getFavoriteTvShows().observe(viewLifecycleOwner) { listTvShow ->
                        favoriteListAdapter.submitList(listTvShow)
                        if (listTvShow != null && !listTvShow.isEmpty()) {
                            binding?.rvFilm?.adapter.let {
                                binding?.apply {
                                    tvNoData.visibility = View.GONE
                                    progressBarWrapper.progressBar.visibility = View.GONE
                                }
                            }
                        } else {
                            binding?.tvNoData?.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }


        binding?.rvFilm?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favoriteListAdapter
        }

    }


    private fun showSelectedData(catalogue: ListEntity) {
        startActivity(Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_ID, catalogue.id)
            putExtra(DetailActivity.EXTRA_TYPE, catalogue.type)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TYPE = "type"

        @JvmStatic
        fun newInstance(type: String): FavoriteListFragment =
            FavoriteListFragment().apply { arguments = Bundle().apply { putString(TYPE, type) } }
    }
}