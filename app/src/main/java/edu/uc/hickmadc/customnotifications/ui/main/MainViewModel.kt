package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.service.GroupService
import java.util.logging.Logger

class MainViewModel : ViewModel() {

    var groups : ArrayList<Group> = ArrayList()
    var groupService : GroupService = GroupService()

    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    fun getAllGroups(): ArrayList<Group> {
        groups = groupService.getAllGroups()
        return groups

    }
}