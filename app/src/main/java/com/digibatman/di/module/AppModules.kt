package com.digibatman.di.module

import android.content.Context
import com.digibatman.ui.general.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModules {


    @Provides
    fun providesMainApplicationInstance(@ApplicationContext context: Context): MyApplication {
        return context as MyApplication
    }

}
