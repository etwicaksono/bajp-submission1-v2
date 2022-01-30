package com.etwicaksono.infomovie2.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.R
import com.etwicaksono.infomovie2.data.source.local.entity.DetailEntity
import com.etwicaksono.infomovie2.databinding.ActivityDetailBinding
import com.etwicaksono.infomovie2.utils.Helper.API_IMAGE_ENDPOINT
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W185
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.etwicaksono.infomovie2.utils.Helper.TYPE_MOVIE
import com.etwicaksono.infomovie2.utils.Helper.TYPE_TV
import com.etwicaksono.infomovie2.utils.Helper.setImageWithGlide
import com.etwicaksono.infomovie2.valueobject.Status
import com.etwicaksono.infomovie2.viewmodel.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolbar()


        val id = intent.getIntExtra(EXTRA_ID, 1)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        when (type) {
            TYPE_MOVIE -> {
                viewModel.getMovieDetail(id).observe(this) { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                showLoading(false)
                                movie.data?.let { setView(it) }
                            }
                            Status.ERROR -> {
                                showLoading(false)
                                Toast.makeText(this, "terjadi kesalahan!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }

            }
            TYPE_TV -> {
                viewModel.getTvDetail(id).observe(this) { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                showLoading(false)
                                movie.data?.let { setView(it) }
                            }
                            Status.ERROR -> {
                                showLoading(false)
                                Toast.makeText(this, "terjadi kesalahan!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }

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

    private fun showLoading(show: Boolean) {
        if (show) {
            binding.progressBar?.visibility = View.VISIBLE
        } else {
            binding.progressBar?.visibility = View.GONE
        }
    }

    private fun setView(data: DetailEntity) {
        binding.apply {
            tvTitle.text = data.title
            setImageWithGlide(
                this@DetailActivity,
                API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W185 + data.posterPath,
                ivPoster
            )
            setImageWithGlide(
                this@DetailActivity,
                API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + data.backdropPath,
                ivBackDrop
            )
            tvReleaseDate.text = data.releaseDate
            tvVote.text = data.voteAverage
            tvGenre.text = data.genres
            tvPlot.text = data.overview
            tvRuntime.text = data.runtime

            fab.setOnClickListener {
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                    .from(this@DetailActivity)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan film ini sekarang!")
                    .setText(
                        """
                        Ada film seru loh, yuk nonton sekarang! Nih aku kasih infonya.
                        Movie : ${data.title}
                        Tahun : ${data.year}
                        Sinopsis : ${data.overview}
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