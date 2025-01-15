package io.github.athorfeo.patterns.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.athorfeo.patterns.util.AppLogger
import io.github.athorfeo.patterns.util.Logger
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CommonsModule {
    @Provides
    fun providesLogger(): Logger {
        return AppLogger
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return Gson()
    }
}
