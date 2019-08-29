package com.yevbes.popularmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yevbes.popularmovies.model.Movie
import com.yevbes.popularmovies.model.repository.PopularMoviesRepository

class PopularMoviesViewModel : ViewModel(){

    private var repository: PopularMoviesRepository = PopularMoviesRepository
    private var moviesLiveData: LiveData<List<Movie>>

    init {
        moviesLiveData = repository.getMoviesLiveData()
    }

    fun getMoviesListLiveData(): LiveData<List<Movie>> {
        return moviesLiveData
    }



    override fun onCleared() {
        super.onCleared()
        repository.disposeCompositeDisposable()
    }
}