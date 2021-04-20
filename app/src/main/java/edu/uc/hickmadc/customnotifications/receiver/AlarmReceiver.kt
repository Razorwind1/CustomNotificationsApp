package edu.uc.hickmadc.customnotifications.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import edu.uc.hickmadc.customnotifications.Constants.CUSTOM_NOTIFICATIONS_CHANNEL
import edu.uc.hickmadc.customnotifications.R

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        createNotification(
            context,
            intent.getStringExtra("EXTRA_NOTIFICATION_TITLE")!!,
            intent.getStringExtra("EXTRA_NOTIFICATION_DESC")!!,
            intent.getIntExtra("EXTRA_NOTIFICATION_ID", 0)
        )
    }

    private fun createNotification(context: Context?, title: String, desc: String, notificationId: Int) {
        if (context != null) {
            val builder = NotificationCompat.Builder(context, CUSTOM_NOTIFICATIONS_CHANNEL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(desc)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(context)) {
                notify(notificationId, builder.build())
            }
        }
    }

}