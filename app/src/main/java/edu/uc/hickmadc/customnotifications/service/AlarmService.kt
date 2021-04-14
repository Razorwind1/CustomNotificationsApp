package edu.uc.hickmadc.customnotifications.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.receiver.AlarmReceiver

class AlarmService(private val context: Context) {
    private val alarmManager: AlarmManager? =
        context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

    private fun buildIntent(notification: Notification): PendingIntent {
        return Intent(context, AlarmReceiver::class.java).let { intent ->
            with(intent) {
                putExtra("EXTRA_NOTIFICATION_TITLE", notification.title)
                putExtra("EXTRA_NOTIFICATION_DESC", notification.desc)
                putExtra("EXTRA_NOTIFICATION_ID", notification.notificationId)
            }
            PendingIntent.getBroadcast(context, 0, intent, 0)
        }
    }

    fun setSingleAlarm(triggerMillis: Long, notification: Notification) {
        alarmManager?.set(
            AlarmManager.RTC_WAKEUP,
            triggerMillis,
            buildIntent(notification)
        )
    }

    fun setRepeatingAlarm(notification: Notification, triggerMillis: Long, intervalMillis: Long) {
        alarmManager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            triggerMillis,
            intervalMillis,
            buildIntent(notification)
        )
    }
}