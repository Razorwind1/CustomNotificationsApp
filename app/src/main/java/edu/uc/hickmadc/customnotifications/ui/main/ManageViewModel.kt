package edu.uc.hickmadc.customnotifications.ui.main

import android.app.Notification
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManageViewModel:ViewModel() {

    val notification: MutableLiveData<Notification> by lazy {
        MutableLiveData<Notification>()

    }

}