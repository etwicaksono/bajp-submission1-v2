package com.etwicaksono.infomovie2.ui.homelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.databinding.ItemsRowMovieBinding
import com.etwicaksono.infomovie2.utils.Helper

class ListAdapter(private val onClick: (ListEntity) -> Unit) :
    PagedListAdapter<ListEntity, ListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val binding =
            ItemsRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListEntity>() {
            override fun areItemsTheSame(oldItem: ListEntity, newItem: ListEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListEntity, newItem: ListEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemsRowMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogue: ListEntity) {
            with(binding) {
                imgMovie.let {
                    Helper.setImageWithGlide(
                        binding.root.context,
                        Helper.API_IMAGE_ENDPOINT + Helper.ENDPOINT_POSTER_SIZE_W185 + catalogue.posterPath,
                        it
                    )
                }
                "${catalogue.title} (${catalogue.year})".also { tvTitle.text = it }
                tvReleaseDate.text = catalogue.releaseDate
                tvPlot.text = catalogue.plot
                tvVote.text=catalogue.vote.toString()

                itemRowMovie.setOnClickListener {
                    onClick(catalogue)
                }
            }
        }

    }
}