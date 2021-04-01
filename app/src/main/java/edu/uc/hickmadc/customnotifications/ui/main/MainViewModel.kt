package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Alarm
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.GroupService
import java.util.logging.Logger

class MainViewModel : ViewModel() {

    var groups : ArrayList<Group> = ArrayList()
    var groupService : GroupService = GroupService()
    private var _notification = Notification()
    private var _notifications : MutableLiveData<ArrayList<Notification>> = MutableLiveData<ArrayList<Notification>>()
    private var _groups: MutableLiveData<ArrayList<Group>> = MutableLiveData<ArrayList<Group>>()
    private var _alarms : MutableLiveData<ArrayList<Alarm>> = MutableLiveData<ArrayList<Alarm>>()

    /**
     * Debugging function for add group button.
     */
    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    /**
     * Fetch all groups. (Placeholder, to be replaced with database call)
     * @return an ArrayList of groups
     */
    fun getAllGroups(): ArrayList<Group> {
        groups = groupService.getAllGroups()
        return groups
    }


    internal var notification: Notification
    get() {return _notification}
    set(value) {_notification = value}

    internal var notifications: MutableLiveData<ArrayList<Notification>>
    get() {return _notifications}
    set(value) {_notifications = value}

    /**internal var group: Group
     *     get() {return _group}
     *     set(value) {_group = value}
     */

    internal var dbgroups: MutableLiveData<ArrayList<Group>>
        get() {return _groups}
        set(value) {_groups = value}

    /**internal var alarm: Alarm
     *     get() {return _alarm}
     *     set(value) {_alarm = value}
     */

    internal var alarms: MutableLiveData<ArrayList<Alarm>>
        get() {return _alarms}
        set(value) {_alarms = value}
}