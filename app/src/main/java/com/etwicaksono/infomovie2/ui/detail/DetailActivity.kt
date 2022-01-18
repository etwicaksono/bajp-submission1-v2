package com.etwicaksono.infomovie2.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.databinding.ActivityDetailBinding
import com.etwicaksono.infomovie2.utils.Helper.API_IMAGE_ENDPOINT
import com.etwicaksono.infomovie2.utils.Helper.ENDPOINT_POSTER_SIZE_W780
import com.etwicaksono.infomovie2.utils.Helper.setImageWithGlide

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
        viewModel.getItem()
        val item = viewModel.item

        binding.apply {
            tvTitle.text = item.title
            ivPoster.let {
                setImageWithGlide(
                    this@DetailActivity,
                    API_IMAGE_ENDPOINT + ENDPOINT_POSTER_SIZE_W780 + item.posterPath,
                    it
                )
            }
            tvReleaseDate.text = item.releaseDate

            fab.setOnClickListener {
                val selected = if (item.type == "movies") "movie" else "tv show"
                val mimeType = "text/plain"
                ShareCompat.IntentBuilder
                    .from(this@DetailActivity)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan $selected ini sekarang!")
                    .setText(
                        """
                        Ada $selected seru loh, yuk nonton sekarang! Nih aku kasih infonya.
                        Movie : ${item.title}
                        Tahun : ${item.year}
                        Sinopsis : ${item.plot}
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