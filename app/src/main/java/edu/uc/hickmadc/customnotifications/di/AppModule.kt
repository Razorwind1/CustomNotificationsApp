package edu.uc.hickmadc.customnotifications.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.uc.hickmadc.customnotifications.dao.NotificationDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: NotificationDatabase.Callback
    ) = Room.databaseBuilder(app, NotificationDatabase::class.java, "notification_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideNotificationDao(db: NotificationDatabase) = db.notificationDAO()

    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}