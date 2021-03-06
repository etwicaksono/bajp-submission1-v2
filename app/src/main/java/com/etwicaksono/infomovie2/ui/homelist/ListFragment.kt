package com.etwicaksono.infomovie2.ui.homelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.databinding.FragmentListBinding
import com.etwicaksono.infomovie2.ui.detail.DetailActivity
import com.etwicaksono.infomovie2.ui.favoritelist.FavoriteActivity
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.utils.SortUtils
import com.etwicaksono.infomovie2.valueobject.Resource
import com.etwicaksono.infomovie2.valueobject.Status
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: ListViewModel
    private lateinit var listAdapter: ListAdapter
    private lateinit var type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


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
        arguments?.apply {
            getString(TYPE)?.let { type = it }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(
                this,
                factory
            )[ListViewModel::class.java]

            viewModel.sort.value = SortUtils.TITLE

            listAdapter = ListAdapter {
                showSelectedData(it)
            }

            setData()
        }


        binding?.rvFilm?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listAdapter
        }

    }

    private fun setData() {
        when (type) {
            Helper.TYPE_MOVIE -> {
                viewModel.getAllMovies().observe(viewLifecycleOwner, listMovieObserver)
            }
            Helper.TYPE_TV -> {
                viewModel.getAllTvShows().observe(viewLifecycleOwner, listTvShowObserver)
            }
        }
    }


    private val listMovieObserver = Observer<Resource<PagedList<ListEntity>>> { listMovies ->
        if (listMovies != null) {
            when (listMovies.status) {
                Status.LOADING -> binding?.progressBarWrapper?.progressBar?.visibility =
                    View.VISIBLE
                Status.SUCCESS -> {
                    binding?.rvFilm?.adapter.let {
                        listAdapter.submitList(listMovies.data)
                        binding?.apply {
                            progressBarWrapper.progressBar.visibility =
                                View.GONE
                            if (listMovies.data == null || listMovies.data.isEmpty()) {
                                tvNoData.visibility =
                                    View.VISIBLE
                            } else {
                                tvNoData.visibility =
                                    View.GONE
                            }
                        }
                    }
                }
                Status.ERROR -> {
                    binding?.progressBarWrapper?.progressBar?.visibility =
                        View.GONE
                    Toast.makeText(
                        context,
                        "Terjadi kesalahan",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                }
            }
        }
    }

    private val listTvShowObserver = Observer<Resource<PagedList<ListEntity>>> { listTvShow ->
        if (listTvShow != null) {
            when (listTvShow.status) {
                Status.LOADING -> binding?.progressBarWrapper?.progressBar?.visibility =
                    View.VISIBLE
                Status.SUCCESS -> {
                    binding?.rvFilm?.adapter.let {
                        listAdapter.submitList(listTvShow.data)
                        binding?.apply {
                            tvNoData.visibility = View.GONE
                            progressBarWrapper.progressBar.visibility =
                                View.GONE
                        }
                    }
                }
                Status.ERROR -> {
                    binding?.progressBarWrapper?.progressBar?.visibility =
                        View.GONE
                    Toast.makeText(
                        context,
                        "Terjadi kesalahan",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                }
            }
        }

    }


    private fun showSelectedData(catalogue: ListEntity) {
        startActivity(Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_ID, catalogue.id)
            putExtra(DetailActivity.EXTRA_TYPE, catalogue.type)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)

        when (viewModel.sort.value) {
            SortUtils.TITLE -> menu.findItem(R.id.action_title).isChecked = true
            SortUtils.VOTE -> menu.findItem(R.id.action_vote).isChecked = true
            SortUtils.RELEASE_DATE -> menu.findItem(R.id.action_release_date).isChecked = true
            SortUtils.RANDOM -> menu.findItem(R.id.action_random).isChecked = true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> startActivity(
                Intent(
                    context,
                    FavoriteActivity::class.java
                )
            )
            R.id.action_title -> viewModel.sort.value = SortUtils.TITLE
            R.id.action_vote -> viewModel.sort.value = SortUtils.VOTE
            R.id.action_release_date -> viewModel.sort.value = SortUtils.RELEASE_DATE
            R.id.action_random -> viewModel.sort.value = SortUtils.RANDOM
        }
        item.isChecked = true
        setData()
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TYPE = "type"

        @JvmStatic
        fun newInstance(type: String): ListFragment =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(TYPE, type)
                }
            }
    }
}