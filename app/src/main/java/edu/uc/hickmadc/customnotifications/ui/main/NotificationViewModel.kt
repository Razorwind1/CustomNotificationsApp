package edu.uc.hickmadc.customnotifications.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.NotificationService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private var _notificationService: NotificationService = NotificationService(application)
    private var _notification = Notification()
    private var _notifications: MutableLiveData<ArrayList<Notification>> = MutableLiveData<ArrayList<Notification>>()

    internal var notificationService: NotificationService
        get() {return _notificationService}
        set(value) {_notificationService = value}

    internal var notification: Notification
        get() {return _notification}
        set(value) {_notification = value}

    internal var notifications: MutableLiveData<ArrayList<Notification>>
        get() {return _notifications}
        set(value) {_notifications = value}

    fun saveNotification(notification: Notification) {
        viewModelScope.async {
            _notificationService.save(notification)
        }
    }

    fun deleteNotification(notification: Notification) {
        viewModelScope.async {
            _notificationService.delete(notification)
        }
    }

    fun updateNotification(notification: Notification) {
        viewModelScope.async {
            _notificationService.update(notification)
        }
    }

    /**
     * Test function
     *
     * WIP; does not work
     */
    @ExperimentalCoroutinesApi
    fun fetchNotification(notificationTitle: String): LiveData<List<Notification>> {
        val deferred = viewModelScope.async {
            _notificationService.search(notificationTitle)
        }
        return deferred.getCompleted()
    }
}