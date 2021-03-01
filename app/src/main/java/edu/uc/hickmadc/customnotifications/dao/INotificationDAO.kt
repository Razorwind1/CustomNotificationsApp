package edu.uc.hickmadc.customnotifications.dao

import edu.uc.hickmadc.customnotifications.dto.Notification
import retrofit2.Call
import retrofit2.http.GET

/**
 * Notification DAO
 *
 * Uses Retrofit to grab data from JSON files
 * Might be deleted, not  sure if we will implement this
 */
interface INotificationDAO {

    @GET("placeholder") //placeholder URL
    suspend fun getAllNotifications(): ArrayList<Notification>
}