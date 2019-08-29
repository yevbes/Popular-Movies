package com.yevbes.popularmovies.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.yevbes.popularmovies.App
import com.yevbes.popularmovies.R
import com.yevbes.popularmovies.model.Movie
import com.yevbes.popularmovies.view.activity.MOVIE_GSON
import com.yevbes.popularmovies.view.activity.MovieDetailsActivity
import com.yevbes.popularmovies.view.adapter.PopularMoviesAdapter
import com.yevbes.popularmovies.view.callback.OnItemClickListener
import com.yevbes.popularmovies.viewmodel.PopularMoviesViewModel
import kotlinx.android.synthetic.main.fragment_popular_movies_list.*


class PopularMoviesListFragment : Fragment() {
    private lateinit var popularMoviesViewModel: PopularMoviesViewModel

    private val mAdapter: PopularMoviesAdapter by lazy {
        PopularMoviesAdapter(arrayListOf(), object : OnItemClickListener {
            override fun onItemClick(view: View) {
                val position = recycler_view_popular_movies.getChildAdapterPosition(view)
                val movie = mAdapter.movieList[position]

                val intent = Intent(activity, MovieDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putString(MOVIE_GSON, Gson().toJson(movie))
                intent.putExtras(bundle)
                startActivity(intent)
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movies_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        val observer = Observer<List<Movie>> { movies -> mAdapter.addAllMovies(movies) }
        popularMoviesViewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)

        popularMoviesViewModel.getMoviesListLiveData().observe(
            this,
            observer
        )
    }

    private fun setupRecyclerView() {

        recycler_view_popular_movies.layoutManager = LinearLayoutManager(
            App.getApplication()
        )
        recycler_view_popular_movies.adapter = mAdapter
    }

}
