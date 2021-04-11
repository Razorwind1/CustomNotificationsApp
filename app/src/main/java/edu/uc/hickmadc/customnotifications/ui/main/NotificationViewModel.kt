package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.uc.hickmadc.customnotifications.service.NotificationService
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationService: NotificationService
) :
    ViewModel() {

    val notifications = notificationService.getNotifications().asLiveData()

//    private var _notificationService: NotificationService = NotificationService(application)
//    private var _notification = Notification()
//    private var _notifications: MutableLiveData<ArrayList<Notification>> = MutableLiveData<ArrayList<Notification>>()
//
//    internal var notificationService: NotificationService
//        get() {return _notificationService}
//        set(value) {_notificationService = value}
//
//    internal var notification: Notification
//        get() {return _notification}
//        set(value) {_notification = value}
//
//    internal var notifications: MutableLiveData<ArrayList<Notification>>
//        get() {return _notifications}
//        set(value) {_notifications = value}
//
//    fun saveNotification(notification: Notification) {
//        viewModelScope.async {
//            _notificationService.save(notification)
//        }
//    }
//
//    fun deleteNotification(notification: Notification) {
//        viewModelScope.async {
//            _notificationService.delete(notification)
//        }
//    }
//
//    fun updateNotification(notification: Notification) {
//        viewModelScope.async {
//            _notificationService.update(notification)
//        }
//    }
//
//    /**
//     * Test function
//     *
//     * WIP; does not work
//     */
//    @ExperimentalCoroutinesApi
//    fun fetchNotification(notificationTitle: String): LiveData<List<Notification>> {
//        val deferred = viewModelScope.async {
//            _notificationService.search(notificationTitle)
//        }
//        return deferred.getCompleted()
//    }
}