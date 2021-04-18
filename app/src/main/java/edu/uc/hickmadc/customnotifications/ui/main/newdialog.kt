package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import edu.uc.hickmadc.customnotifications.R

class newdialog : DialogFragment(){

    private lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View {
        //gets dialog fragment
        rootView = inflater.inflate(R.layout.notification_dialog, container, false)

        return rootView
    }

}