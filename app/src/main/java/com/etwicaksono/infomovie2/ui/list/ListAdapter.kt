package com.etwicaksono.infomovie2.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etwicaksono.infomovie2.data.MovieEntity
import com.etwicaksono.infomovie2.databinding.ItemsRowMovieBinding

class ListAdapter(private val onClick: (MovieEntity) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ItemsRowMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                imgMovie.setImageResource(
                    root.resources.getIdentifier(
                        movie.poster,
                        "drawable",
                        root.context.packageName
                    )
                )
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                tvPlot.text = movie.plot

                itemRowMovie.setOnClickListener {
                    onClick(movie)
                }
            }
        }

    }

    private val listMovies = ArrayList<MovieEntity>()

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

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
}