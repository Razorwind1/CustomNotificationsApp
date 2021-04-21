package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.uc.hickmadc.customnotifications.dto.Notification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Notification::class], version = 1, exportSchema = false)
abstract class NotificationDatabase : RoomDatabase() {
    abstract fun notificationDAO(): INotificationDAO

    class Callback @Inject() constructor(
        private val database: Provider<NotificationDatabase>,
        private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().notificationDAO()

            // prepopulate with test data
            applicationScope.launch {
                dao.insert(
                    Notification(
                        "Notification 3",
                        "A third notification",
                        "A third description",
                        "04/20/2021",
                        "",
                        "18:30",
                        "Never"
                    )
                )
                dao.insert(
                    Notification(
                        "Notification 2",
                        "A second notification",
                        "A second description",
                        "03/28/2021",
                        "",
                        "19:00",
                        "Daily"
                    )
                )
                dao.insert(
                    Notification(
                        "Notification 1",
                        "A notification",
                        "A description",
                        "04/12/2021",
                        "",
                        "09:30",
                        "Monthly"
                    )
                )
                dao.insert(
                    Notification(
                        "Notification 4 ",
                        "A fourth notification",
                        "A  fourth description",
                        "04/15/2021",
                        "",
                        "12:55",
                        "Never"
                    )
                )
            }
        }
    }
}