package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.dto.Notification


class DialogPopupFragment: DialogFragment() {

    private lateinit var rootView: View
    private lateinit var notificationTitle: TextView
    private lateinit var notificationSubtext: TextView
    private lateinit var notificationDescription: TextView
    private val notificationViewModel: NotificationViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private var notification = Notification()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        //gets dialog fragment
        rootView = inflater.inflate(R.layout.notification_dialog, container, false)

        notificationTitle = rootView.findViewById(R.id.txtTitle)
        notificationSubtext = rootView.findViewById(R.id.txtSubtext)
        notificationDescription = rootView.findViewById(R.id.txtDescription)

        addEventHandlersToDialogBox()

        return rootView
    }

    private fun addEventHandlersToDialogBox() {

        //gets ids for buttons
        val btnClose = rootView.findViewById<ImageButton>(R.id.btnClose)
        val btnConfirm = rootView.findViewById<Button>(R.id.btnConfirm)
        btnClose.setOnClickListener {
            dismiss()
        }

        btnConfirm.setOnClickListener {
            /*
            var notificationToAdd = Notification(
                notificationTitle.text.toString(),
                notificationSubtext.text.toString(),
                notificationDescription.text.toString(),
            )
             */

            saveNotification()
            dismiss()
        }
    }

    internal fun saveNotification() {
        notification.apply {
            title = notificationTitle.text.toString()
            subtext = notificationSubtext.text.toString()
            desc = notificationDescription.text.toString()
        }
        notificationViewModel.saveNotification(notification)
    }
}

