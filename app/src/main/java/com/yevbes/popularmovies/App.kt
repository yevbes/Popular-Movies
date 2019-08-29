package com.yevbes.popularmovies

import android.app.Application
import timber.log.Timber

class App : Application() {
    companion object {
        private lateinit var mApplication: Application

        /**
         * return Application
         */
        @JvmStatic
        fun getApplication(): Application {
            return mApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}