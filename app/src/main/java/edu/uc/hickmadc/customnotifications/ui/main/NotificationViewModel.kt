package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.NotificationService
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationService: NotificationService
) :
    ViewModel() {

    val notifications = notificationService.getNotifications().asLiveData()

    private var currentNotification: LiveData<Notification>? = null

    fun saveNotification(notification: Notification) {
        viewModelScope.launch {
            notificationService.save(notification)
        }
    }

    fun updateNotification(notification: Notification) {
        viewModelScope.launch {
            notificationService.update(notification)
        }
    }

    fun deleteNotification(notification: Notification) {
        viewModelScope.launch {
            notificationService.delete(notification)
        }
    }

    fun get(id: Int): LiveData<Notification> {
        return currentNotification ?: liveData {
            emit(notificationService.get(id))
        }.also {
            currentNotification = it
        }
    }
}