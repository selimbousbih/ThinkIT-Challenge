package com.thinkit.smartyhome.di

import android.content.Context
import com.thinkit.smartyhome.data.local.Preferences
import com.thinkit.smartyhome.data.repository.FakeRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context, private val preferences: Preferences) {
    @Provides
    fun provideContext(): Context = context

    @Provides
    fun providePreferences(): Preferences = preferences

    @Provides
    fun provideFakeRepository(): FakeRepository = FakeRepository()
}