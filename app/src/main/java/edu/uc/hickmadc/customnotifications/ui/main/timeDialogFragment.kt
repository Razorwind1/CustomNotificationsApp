package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import edu.uc.hickmadc.customnotifications.R

class timeDialogFragment: DialogFragment() {

    private lateinit var rootView: View
    private lateinit var timeText: TextView
    private lateinit var switchMon: CheckBox
    private lateinit var switchTue: CheckBox
    private lateinit var switchWed: CheckBox
    private lateinit var switchThu: CheckBox
    private lateinit var switchFri: CheckBox
    private lateinit var switchSat: CheckBox
    private lateinit var switchSun: CheckBox


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.trigger_dialog, container, false)
        timeText= rootView.findViewById(R.id.txtTime)


        addEventHandlersToDialogBox()
        return rootView
    }
    private fun addEventHandlersToDialogBox(){

    }
}