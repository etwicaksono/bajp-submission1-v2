package com.etwicaksono.infomovie2.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.databinding.ActivityDetailBinding
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.utils.Helper.API_IMAGE_ENDPOINT
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.etwicaksono.infomovie2.utils.Helper.setImageWithGlide
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getIntExtra(EXTRA_ID, 1)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        when (type) {
            Helper.TYPE_MOVIE -> {
                viewModel.getMovieDetail(id).observe(this, { movie ->
                    binding.apply {
                        tvTitle.text = movie.title
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + movie.posterPath,
                            ivPoster
                        )
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + movie.backdropPath,
                            ivBackDrop
                        )
                        tvReleaseDate.text = movie.releaseDate
                        tvVote.text=movie.voteAverage
                        tvGenre.text=movie.genres
                        tvPlot.text=movie.overview

                        fab.setOnClickListener {
                            val selected = if (type == "movies") "movie" else "tv show"
                            val mimeType = "text/plain"
                            ShareCompat.IntentBuilder
                                .from(this@DetailActivity)
                                .setType(mimeType)
                                .setChooserTitle("Bagikan $selected ini sekarang!")
                                .setText(
                                    """
                        Ada $selected seru loh, yuk nonton sekarang! Nih aku kasih infonya.
                        Movie : ${movie.title}
                        Tahun : ${movie.year}
                        Sinopsis : ${movie.overview}
                    """.trimIndent()
                                )
                                .startChooser()
                        }
                    }
                })

            }
            Helper.TYPE_TVSHOW -> {
                viewModel.getMovieDetail(id).observe(this, { movie ->
                    binding.apply {
                        tvTitle.text = movie.title
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + movie.posterPath,
                            ivPoster
                        )
                        tvReleaseDate.text = movie.releaseDate

                        fab.setOnClickListener {
                            val selected = if (type == "movies") "movie" else "tv show"
                            val mimeType = "text/plain"
                            ShareCompat.IntentBuilder
                                .from(this@DetailActivity)
                                .setType(mimeType)
                                .setChooserTitle("Bagikan $selected ini sekarang!")
                                .setText(
                                    """
                        Ada $selected seru loh, yuk nonton sekarang! Nih aku kasih infonya.
                        Movie : ${movie.title}
                        Tahun : ${movie.year}
                        Sinopsis : ${movie.overview}
                    """.trimIndent()
                                )
                                .startChooser()
                        }
                    }
                })

            }
        }


    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}