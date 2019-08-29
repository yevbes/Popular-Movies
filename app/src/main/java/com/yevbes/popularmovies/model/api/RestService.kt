package com.yevbes.popularmovies.model.api

import com.yevbes.popularmovies.model.Results
import com.yevbes.popularmovies.utils.API_KEY_PARAM
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {
    @GET("movie/popular")
    fun getTopRatedMovies(
        @Query(API_KEY_PARAM) language: String
    ): Single<Results>
}