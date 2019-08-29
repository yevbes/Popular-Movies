package com.yevbes.popularmovies.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.yevbes.popularmovies.databinding.MovieItemBinding
import com.yevbes.popularmovies.model.Movie

class PopularMoviesViewHolder(
    private val binding: MovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
    }
}