package com.etwicaksono.infomovie2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.databinding.ActivityDetailBinding
import com.etwicaksono.infomovie2.utils.getRuntime

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getIntExtra(EXTRA_ID, 1)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        viewModel.setSelectedItem(type, id)
        viewModel.getItem(this)
        val movie = viewModel.item

        binding.apply {
            tvTitle.text = movie.title
            tvGenre.text = movie.genres
            ivPoster.setImageResource(
                root.resources.getIdentifier(
                    movie.poster,
                    "drawable",
                    this@DetailActivity.packageName
                )
            )
            tvReleaseDate.text = movie.releaseDate
            tvRuntime.text = movie.runtime?.let { getRuntime(it.toInt()) }
            tvPlot.text = movie.plot
            tvDirector.text = movie.director
            tvActors.text = movie.actors
            tvHeader.text =
                if (movie.type == "movies") getString(R.string.detail_movie) else getString(R.string.detail_tv_show)

            fab.setOnClickListener {
                val selected = if (movie.type == "movies") "movie" else "tv show"
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                    .from(this@DetailActivity)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan $selected ini sekarang!")
                    .setText(
                        """
                        Ada $selected seru loh, yuk nonton sekarang! Nih aku kasih infonya.
                        Movie : ${movie.title}
                        Genre : ${movie.genres}
                        Tahun : ${movie.year}
                        Sinopsis : ${movie.plot}
                    """.trimIndent()
                    )
                    .startChooser()
            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}