package edu.uc.hickmadc.customnotifications.service

import edu.uc.hickmadc.customnotifications.dto.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * GroupService class. Handles adding groups to the groups tab.
 *
 * The GroupService class handles adding groups to the groups tabs via a connection to the database.
 * However, this class currently holds some mocked data that emulates what would be stored or
 * fetched from the database.
 */
class GroupService {

    /**
     * getAllGroups function. Essentially a fetchAll() function that returns all the existing
     * groups.
     * @return an arraylist of Group DTO objects.
     */
    fun getAllGroups() : ArrayList<Group>{
        val groups : ArrayList<Group> = ArrayList()
        //placeholder, should be replaced by database call/live data
        groups.add(Group(name = "Group1", desc = "This data is", active = true, same_schedule = false, groupId = 1))
        groups.add(Group(name = "Group2", desc = "set in the", active = false, same_schedule = false, groupId = 1))
        groups.add(Group(name = "Group3", desc = "main view model", active = true, same_schedule = false, groupId = 2))
        return groups
    }

    internal suspend fun fetchGroups (groupName: String)
    {
        withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance
        }
    }
}