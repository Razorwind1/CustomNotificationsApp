package edu.uc.hickmadc.customnotifications.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.uc.hickmadc.customnotifications.service.NotificationService
import kotlinx.coroutines.launch

class ApplicationViewModel(application: Application) : AndroidViewModel(application) {
    private var _notificationService: NotificationService = NotificationService(application)

    init {
        fetchNotifications("f")
    }

    fun fetchNotifications(title: String) {
        viewModelScope.launch{
            _notificationService.fetchNotifications(title)
        }
    }

    internal var notificationService: NotificationService
        get() {return _notificationService}
        set(value) {_notificationService = value}
}