package com.example.dartjonny.di

import android.app.Application
import androidx.room.Room
import com.example.dartjonny.dart_jonny.data.database.PlayerDatabase
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepositoryImpl
import com.example.dartjonny.dart_jonny.useCases.newGame.*
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
    fun provideNewGameUseCases(repository: PlayerRepository): NewGameUseCases {
        return NewGameUseCases(
            getPlayers = GetPlayers(repository),
            deletePlayer = DeletePlayer(repository),
            addPlayer = AddPlayer(repository),
            updatePlayerScore = UpdatePlayerScore(repository)
        )
    }
}