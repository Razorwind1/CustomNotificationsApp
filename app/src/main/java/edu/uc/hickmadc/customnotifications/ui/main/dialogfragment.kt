package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.dto.Notification


class dialogfragment: DialogFragment() {

    private lateinit var rootView: View
    private lateinit var notificationTitleText: TextView
    private lateinit var notificationSubtext: TextView
    private lateinit var notificationText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        //gets dialog fragment
        rootView = inflater.inflate(R.layout.notification_dialog, container, false)

        notificationTitleText = rootView.findViewById(R.id.txtTime)
        notificationSubtext = rootView.findViewById(R.id.txtSubtext)
        notificationText = rootView.findViewById(R.id.notificationText)

        addEventHandlersToDialogBox()

        return rootView
    }

    private fun addEventHandlersToDialogBox() {

        //gets ids for buttons
        var btnClose = rootView.findViewById<ImageButton>(R.id.closeButton)
        var btnConfirm = rootView.findViewById<Button>(R.id.btnconfirm)
        var switch= rootView.findViewById<Switch>(R.id.SWTriggerToggle)

        btnClose.setOnClickListener {
            dismiss()
        }

        btnConfirm.setOnClickListener {

            var notificationToAdd: Notification = Notification(
                notificationTitleText.text.toString(),
                notificationSubtext.text.toString(),
                notificationText.text.toString(),
                0
            )
        }
        switch.setOnClickListener{
            var switchText= switch.text
            if (switchText.equals("Time")){
                switch.text= "Location"
            }else{
                switch.text="Time"
                var dialog= timeDialogFragment()

                dialog.show(requireActivity().supportFragmentManager!!, "customdialog")
            }


        }

    }
}

