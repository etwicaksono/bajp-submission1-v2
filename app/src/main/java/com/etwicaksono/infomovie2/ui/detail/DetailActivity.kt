package com.etwicaksono.infomovie2.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.databinding.ActivityDetailBinding
import com.etwicaksono.infomovie2.utils.Helper
import com.etwicaksono.infomovie2.utils.Helper.API_IMAGE_ENDPOINT
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W185
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.etwicaksono.infomovie2.utils.Helper.TYPE_MOVIE
import com.etwicaksono.infomovie2.utils.Helper.setImageWithGlide
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolbar()


        val id = intent.getIntExtra(EXTRA_ID, 1)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        when (type) {
            TYPE_MOVIE -> {
                viewModel.getMovieDetail(id).observe(this, { movie ->
                    binding.apply {
                        tvTitle.text = movie.title
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W185 + movie.posterPath,
                            ivPoster
                        )
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + movie.backdropPath,
                            ivBackDrop
                        )
                        tvReleaseDate.text = movie.releaseDate
                        tvVote.text = movie.voteAverage
                        tvGenre.text = movie.genres
                        tvPlot.text = movie.overview
                        tvRuntime.text = movie.runtime

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
                viewModel.getTvDetail(id).observe(this, { movie ->
                    binding.apply {
                        tvTitle.text = movie.title
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W185 + movie.posterPath,
                            ivPoster
                        )
                        setImageWithGlide(
                            this@DetailActivity,
                            API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + movie.backdropPath,
                            ivBackDrop
                        )
                        tvReleaseDate.text = movie.releaseDate
                        tvVote.text = movie.voteAverage
                        tvGenre.text = movie.genres
                        tvPlot.text = movie.overview
                        tvRuntime.text = movie.runtime

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

    private fun setUpToolbar() {
        binding.apply {
            appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (collapseToolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                        collapseToolbar
                    )
                ) {
                    collapseToolbar.setCollapsedTitleTextColor(Color.BLACK)
                    toolbar.apply {
                        setBackgroundColor(Color.WHITE)
                        title =
                            if (intent.getStringExtra(EXTRA_TYPE) == TYPE_MOVIE) context.getString(R.string.detail_movie) else context.getString(
                                R.string.detail_tv_show
                            )
                        visibility = View.VISIBLE
                    }
                } else {
                    collapseToolbar.setExpandedTitleColor(Color.TRANSPARENT)
                    toolbar.apply {
                        setBackgroundColor(Color.TRANSPARENT)
                        visibility = View.GONE
                    }
                }
            })

            toolbar.apply {
                setNavigationIcon(R.drawable.ic_back)
                setNavigationOnClickListener { onBackPressed() }
            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}