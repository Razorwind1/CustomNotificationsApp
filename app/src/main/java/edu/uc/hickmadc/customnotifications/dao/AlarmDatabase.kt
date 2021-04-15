package edu.uc.hickmadc.customnotifications.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.uc.hickmadc.customnotifications.dto.Alarm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Alarm::class], version = 1, exportSchema = false)
abstract class AlarmDatabase : RoomDatabase() {
    abstract fun alarmDAO(): IAlarmDAO

    class Callback @Inject() constructor(
        private val database: Provider<AlarmDatabase>,
        private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().alarmDAO()

            // prepopulate with test data
            applicationScope.launch {
                dao.insert(
                    Alarm(
                        "Alarm 3",
                        "A third alarm",
                        true
                    )
                )
                dao.insert(
                    Alarm(
                        "Notification 2",
                        "A second alarm",
                        false
                    )
                )
                dao.insert(
                    Alarm(
                        "Notification 1",
                        "An alarm",
                        true
                    )
                )
            }
        }
    }
}