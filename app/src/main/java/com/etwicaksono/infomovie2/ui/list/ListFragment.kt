package com.etwicaksono.infomovie2.ui.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.etwicaksono.infomovie2.data.CatalogueModel
import com.etwicaksono.infomovie2.databinding.FragmentListBinding
import com.etwicaksono.infomovie2.ui.detail.DetailActivity
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: ListViewModel
    private lateinit var listAdapter: ListAdapter
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
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(
                this,
                factory
            )[ListViewModel::class.java]

            listAdapter = ListAdapter {
                showSelectedData(it)
            }

            when (type) {
                Helper.TYPE_MOVIE -> {
                    viewModel.getAllMovies().observe(viewLifecycleOwner, { listMovies ->
                        binding?.rvFilm?.adapter.let { adapter ->
                            when (adapter) {
                                is ListAdapter -> listAdapter.setMovies(listMovies)
                            }
                        }
                    })
                }
                Helper.TYPE_TVSHOW -> {
                }
            }


            binding?.rvFilm?.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listAdapter
            }

        }
    }

    private fun showSelectedData(catalogue: CatalogueModel) {
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
        fun newInstance(type: String): ListFragment =
            ListFragment().apply { arguments = Bundle().apply { putString(TYPE, type) } }
    }
}