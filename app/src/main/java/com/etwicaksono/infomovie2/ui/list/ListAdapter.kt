package com.etwicaksono.infomovie2.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etwicaksono.infomovie2.data.source.local.entity.ListEntity
import com.etwicaksono.infomovie2.databinding.ItemsRowMovieBinding
import com.etwicaksono.infomovie2.utils.Helper

class ListAdapter(private val onClick: (ListEntity) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemsRowMovieBinding) :
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

                itemRowMovie.setOnClickListener {
                    onClick(catalogue)
                }
            }
        }

    }

    private val listMovies = ArrayList<ListEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val binding =
            ItemsRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    fun setList(catalogues: List<ListEntity>?) {
        if (catalogues == null) return
        this.listMovies.clear()
        this.listMovies.addAll(catalogues)
        notifyDataSetChanged()
    }
}