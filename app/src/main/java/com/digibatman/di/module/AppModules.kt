package com.digibatman.di.module

import android.content.Context
import androidx.room.Room
import com.digibatman.di.database.AppDatabase
import com.digibatman.ui.general.MyApplication
import com.digibatman.util.APP_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        APP_DATABASE
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase) = db.MovieDAO()

    @Singleton
    @Provides
    fun provideDetailsDao(db: AppDatabase) = db.detailsDAO()

    @Provides
    fun providesMainApplicationInstance(@ApplicationContext context: Context): MyApplication {
        return context as MyApplication
    }

}
