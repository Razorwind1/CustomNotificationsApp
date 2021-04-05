package edu.uc.hickmadc.customnotifications.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import edu.uc.hickmadc.customnotifications.dto.Group
import java.util.logging.Logger

class MainViewModel : ViewModel() {
    val groups : ArrayList<Group> = ArrayList()


    fun exampleClick() {
        Logger.getAnonymousLogger().warning("You just pressed the add group button")
    }

    fun getAllGroups() : ArrayList<Group> {
        //placeholder, should be replaced by database call/live data
        with(groups) {
        add(Group(name = "Group1", desc = "This data is", active = true, same_schedule = false, group_id = 1))
        add(Group(name = "Group2", desc = "set in the", active = false, same_schedule = false, group_id = 1))
        add(Group(name = "Group3", desc = "main view model", active = true, same_schedule = false, group_id = 2))
        }
        return groups
    }
}