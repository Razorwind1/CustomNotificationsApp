package edu.uc.hickmadc.customnotifications.ui.main

import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Group
import java.util.logging.Logger

class MainViewModel : ViewModel() {

    /**
     * Debugging function for add group button.
     */
    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    /**
     * Fetch all groups.
     * @return an ArrayList of groups
     */
    fun getAllGroups(): ArrayList<Group> {
        var groups: ArrayList<Group> = ArrayList()
        //TODO: Replace placeholder.
        groups.add(
            Group(
                groupName = "Group1",
                groupDescription = "This data is",
                groupActive = true,
                sameSchedule = false,
                groupId = 1
            )
        )
        groups.add(
            Group(
                groupName = "Group2",
                groupDescription = "set in the",
                groupActive = false,
                sameSchedule = false,
                groupId = 2
            )
        )
        groups.add(
            Group(
                groupName = "Group3",
                groupDescription = "main view model",
                groupActive = true,
                sameSchedule = false,
                groupId = 3
            )
        )
        return groups
    }
}