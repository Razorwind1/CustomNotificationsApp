package edu.uc.hickmadc.customnotifications.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import edu.uc.hickmadc.customnotifications.R


class DialogPopupFragment: DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?{
        //gets dialog fragment
        var rootView: View= inflater.inflate(R.layout.notification_dialog,container,false)
        //gets ids for buttons
        var btnClose= rootView.findViewById<Button>(R.id.btnClose)
        var btnConfirm = rootView.findViewById<Button>(R.id.btnConfirm)
        btnClose.setOnClickListener {
            dismiss()
        }


        return rootView


    }
}