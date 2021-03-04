package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Group
import java.util.logging.Logger

class MainViewModel : ViewModel() {
    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    fun getAllGroups(): ArrayList<Group> {
        var groups: ArrayList<Group> = ArrayList()
        //placeholder, should be replaced by database call/live data
        groups.add(
            Group(
                name = "Group1",
                desc = "This data is",
                active = true,
                sameSchedule = false,
                groupId = 1
            )
        )
        groups.add(
            Group(
                name = "Group2",
                desc = "set in the",
                active = false,
                sameSchedule = false,
                groupId = 2
            )
        )
        groups.add(
            Group(
                name = "Group3",
                desc = "main view model",
                active = true,
                sameSchedule = false,
                groupId = 3
            )
        )
        return groups
    }
}