package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import edu.uc.hickmadc.customnotifications.R

class TriggersFragment : DialogFragment(){
    private lateinit var rootView: View
    private lateinit var time: TextView
    private lateinit var ckMon: CheckBox
    private lateinit var ckTue: CheckBox
    private lateinit var ckWen: CheckBox
    private lateinit var ckThu: CheckBox
    private lateinit var ckFri: CheckBox
    private lateinit var ckSat: CheckBox
    private lateinit var ckSun: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        //gets dialog fragment
        rootView = inflater.inflate(R.layout.trigger_dialog, container, false)


        return rootView
    }
    private fun addEventHandlersToDialogBox(){
        val btnClose= rootView.findViewById<ImageButton>(R.id.closeButton)
        val btnConfirm= rootView.findViewById<Button>(R.id.btnconfirm)

        btnClose.setOnClickListener{

        }
        btnConfirm.setOnClickListener{

        }

    }

}