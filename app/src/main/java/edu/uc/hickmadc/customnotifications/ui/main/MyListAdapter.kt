package edu.uc.hickmadc.customnotifications.ui.main

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import edu.uc.hickmadc.customnotifications.R

class MyListAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val description: Array<String>
) : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    /**
     * Gets the current position of the view, then spits out an inflated row view.
     * @return an inflated list of items.
     */
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)
        val titleText = rowView.findViewById(R.id.title) as TextView
        val subtitleText = rowView.findViewById(R.id.description) as TextView

        titleText.text = title[position]

        subtitleText.text = description[position]

        return rowView
    }
}