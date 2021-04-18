package edu.uc.hickmadc.customnotifications.ui.main

import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
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

}