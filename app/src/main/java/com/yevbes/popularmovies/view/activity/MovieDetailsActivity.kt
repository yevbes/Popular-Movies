package com.yevbes.popularmovies.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.yevbes.popularmovies.R
import com.yevbes.popularmovies.databinding.ActivityMovieDetailsBinding
import com.yevbes.popularmovies.model.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*

const val MOVIE_GSON = "MOVIE_GSON"
class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        setSupportActionBar(tb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tb.setNavigationOnClickListener {
            onBackPressed()
        }

        val movieGson = intent.getStringExtra(MOVIE_GSON)
        val movie: Movie = Gson().fromJson(movieGson, Movie::class.java)
        binding.movie = movie
    }
}
