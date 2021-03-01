package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.NotificationService
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var _notifications: MutableLiveData<ArrayList<Notification>> = MutableLiveData<ArrayList<Notification>>()
    private var _notification = Notification()

    internal var notifications: MutableLiveData<ArrayList<Notification>>
        get() {return _notifications}
        set(value) {_notifications = value}

    internal var notification: Notification
        get() {return _notification}
        set(value) {_notification = value}
}