package com.yevbes.popularmovies.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yevbes.popularmovies.databinding.MovieItemBinding
import com.yevbes.popularmovies.model.Movie
import com.yevbes.popularmovies.view.callback.OnItemClickListener

class PopularMoviesAdapter(
    val movieList: ArrayList<Movie>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = MovieItemBinding.inflate(layoutInflater, parent, false)

        rowBinding.root.setOnClickListener { view ->
            listener.onItemClick(view)
        }


        return PopularMoviesViewHolder(rowBinding)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    fun addAllMovies(items: List<Movie>) {
        this.movieList.addAll(items)
        notifyItemRangeInserted(itemCount, items.size)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}