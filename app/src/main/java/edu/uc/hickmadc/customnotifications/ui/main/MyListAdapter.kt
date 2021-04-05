package edu.uc.hickmadc.customnotifications.ui.main
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import edu.uc.hickmadc.customnotifications.R

class MyListAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>,private val days: Array<String>,private val times: Array<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
/**
 * Gets the current position of the view, then spits out an inflated row view.
 * @return an inflated list of items.
 */
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView

        val subtitleText = rowView.findViewById(R.id.Description) as TextView

        val daysText= rowView.findViewById(R.id.days) as TextView

        val timesText= rowView.findViewById<TextView>(R.id.Time)

        titleText.text = title[position]

        subtitleText.text = description[position]

        daysText.text= days[position]

        timesText.text= times[position]
        return rowView
    }
}