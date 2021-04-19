package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.service.GroupService
import java.util.logging.Logger

class MainViewModel : ViewModel() {

    var groups: ArrayList<Group> = ArrayList()
    var groupService: GroupService = GroupService()

    /**
     * Debugging function for add group button.
     */
    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    /**
     * Uses group service to create new group in database
     *
     * @param group The Group object to save
     */
    fun createGroup(group: Group): Int {
        Logger.getAnonymousLogger().warning(group.toString())
        return groupService.createGroup(group)
    }

    /**
     * Fetch all groups.
     * @return an ArrayList of groups
     */
    fun getAllGroups(): ArrayList<Group> {
        groups = groupService.getAllGroups()
        return groups
    }
}