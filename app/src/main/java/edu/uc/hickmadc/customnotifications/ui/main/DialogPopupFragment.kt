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
import androidx.navigation.fragment.findNavController
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.dao.NotificationDatabase
import edu.uc.hickmadc.customnotifications.dto.Notification


class DialogPopupFragment: DialogFragment() {

    private lateinit var rootView: View
    private lateinit var notificationTitle: TextView
    private lateinit var notificationSubtext: TextView
    private lateinit var notificationDescription: TextView
    private enum class EditingState{
        NEW_NOTIFICATION,
        EXISTING_NOTIFICATION
    }
    private val notificationViewModel: NotificationViewModel by viewModels(ownerProducer = { requireParentFragment() })

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
        val btnTriggers=rootView.findViewById<Button>(R.id.btnaddTriggers)

        btnTriggers.setOnClickListener{


        }
        btnClose.setOnClickListener {
            dismiss()
        }

        btnConfirm.setOnClickListener {
            saveNotification()
            dismiss()
        }
    }

    private fun saveNotification() {
        notificationViewModel.saveNotification(
            Notification(
                notificationTitle.text.toString(),
                notificationSubtext.text.toString(),
                notificationDescription.text.toString()
            )
        )
    }
}
