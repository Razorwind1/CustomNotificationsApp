package edu.uc.hickmadc.customnotifications.service
import android.app.Application
import androidx.room.Room
import edu.uc.hickmadc.customnotifications.dao.GroupDatabase
import edu.uc.hickmadc.customnotifications.dao.iGroupDAO
import edu.uc.hickmadc.customnotifications.dto.Group
import kotlinx.coroutines.*

/**
 * GroupService class. Handles adding groups to the groups tab.
 *
 * The GroupService class handles adding groups to the groups tabs via a connection to the database.
 * However, this class currently holds some mocked data that emulates what would be stored or
 * fetched from the database.
 */
class GroupService(private val application: Application) {

    /**
     * getAllGroups function. Essentially a fetchAll() function that returns all the existing
     * groups.
     * @return an arraylist of Group DTO objects.
     */
    fun getAllGroups() : ArrayList<Group>{
        val groups : ArrayList<Group> = ArrayList()
        //placeholder, should be replaced by database call/live data
        groups.add(Group(name = "Group1", desc = "This data is", active = true, same_schedule = false, group_id = 1))
        groups.add(Group(name = "Group2", desc = "set in the", active = false, same_schedule = false, group_id = 1))
        groups.add(Group(name = "Group3", desc = "main view model", active = true, same_schedule = false, group_id = 2))
        return groups
    }

    /**
     * Store alarms locally using Room database
     */
    private fun updategroups(groups: ArrayList<Group>?) {
        val groupDAO = getGroupDAO()
        groups?.let{
            groupDAO.insertAll(groups)
        }
    }


    internal fun getGroupDAO(): iGroupDAO {
        val db = Room.databaseBuilder(application, GroupDatabase::class.java, "myGroups").build()
        return db.groupDAO()
    }

    internal fun save(group: Group) {
        getGroupDAO().save(group)
    }

    internal fun delete(group: Group) {
        getGroupDAO().delete(group)
    }
}