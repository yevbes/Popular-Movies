package com.yevbes.popularmovies.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yevbes.popularmovies.model.Movie
import com.yevbes.popularmovies.model.Results
import com.yevbes.popularmovies.model.api.RestService
import com.yevbes.popularmovies.model.api.ServiceGenerator
import com.yevbes.popularmovies.utils.API_KEY
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

object PopularMoviesRepository {
    private val webService: RestService = ServiceGenerator.createService(RestService::class.java)
    private val moviesLiveData = MutableLiveData<List<Movie>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        webService.getTopRatedMovies(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Results>{

                override fun onSuccess(t: Results) {
                    moviesLiveData.postValue(t.results)
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    Timber.d(e)
                }

            })
    }

    fun disposeCompositeDisposable() {
        compositeDisposable.dispose()
    }

    fun getMoviesLiveData(): LiveData<List<Movie>> {
        return moviesLiveData
    }


}