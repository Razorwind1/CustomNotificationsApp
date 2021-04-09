package edu.uc.hickmadc.customnotifications.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.NotificationService
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private var _notificationService: NotificationService = NotificationService(application)
    private var _notifications: MutableLiveData<ArrayList<Notification>> = MutableLiveData()

    internal var notificationService: NotificationService
    get() {return _notificationService}
    set(value) {_notificationService = value}

    internal var notifications: MutableLiveData<ArrayList<Notification>>
    get() {return _notifications}
    set(value) {_notifications = value}

    fun saveNotification(notification: Notification) {
        viewModelScope.launch {
            _notificationService.save(notification)
        }
    }

    fun deleteNotification(notification: Notification) {
        viewModelScope.launch {
            _notificationService.delete(notification)
        }
    }

    fun updateNotification(notification: Notification) {
        viewModelScope.launch {
            _notificationService.update(notification)
        }
    }

    fun fetchNotification(notificationTitle: String) {
        viewModelScope.launch {
            _notificationService.search(notificationTitle)
        }
    }

}