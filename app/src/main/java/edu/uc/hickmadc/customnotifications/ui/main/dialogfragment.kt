package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentContainer
import edu.uc.hickmadc.customnotifications.R
import java.io.FileDescriptor
import java.io.PrintWriter
import java.util.zip.Inflater

class dialogfragment: DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View?{
        var rootView: View= inflater.inflate(R.layout.notification_dialog,container,false)
        return rootView


    }
}