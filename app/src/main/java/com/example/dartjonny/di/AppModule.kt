package com.example.dartjonny.di

import android.app.Application
import androidx.room.Room
import com.example.dartjonny.database.PlayerDatabase
import com.example.dartjonny.repository.PlayerRepository
import com.example.dartjonny.repository.PlayerRepositoryImpl
import com.example.dartjonny.useCases.AddPlayer
import com.example.dartjonny.useCases.DeletePlayer
import com.example.dartjonny.useCases.GetPlayers
import com.example.dartjonny.useCases.PlayerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlayerDatabase(app: Application): PlayerDatabase {
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            PlayerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePlayerRepository(db: PlayerDatabase): PlayerRepository {
        return PlayerRepositoryImpl(db.playerDao)
    }

    @Provides
    @Singleton
    fun providePlayerUseCases(repository: PlayerRepository): PlayerUseCases {
        return PlayerUseCases(
            getPlayers = GetPlayers(repository),
            deletePlayer = DeletePlayer(repository),
            addPlayer = AddPlayer(repository)
        )
    }
}