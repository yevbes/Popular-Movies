package com.yevbes.popularmovies.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.yevbes.popularmovies.App
import com.yevbes.popularmovies.R
import com.yevbes.popularmovies.utils.BASE_IMAGE_URL
import com.yevbes.popularmovies.utils.IMAGE_SIZE


data class Movie(
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") val vote_count: Int,
    @SerializedName("video") val video: Boolean,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("id") val id: Int,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("original_title") val original_title: String,
    @SerializedName("genre_ids") val genre_ids: List<Int>,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val release_date: String
) {
    companion object {
        private fun getImageUrl(): String {
            return BASE_IMAGE_URL + IMAGE_SIZE
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.context)
                .load(getImageUrl() + url)
                .override(
                    App.getApplication().resources.getDimensionPixelSize(R.dimen.poster_width),
                    App.getApplication().resources.getDimensionPixelSize(R.dimen.poster_height))
                .into(view)

        }
    }


}