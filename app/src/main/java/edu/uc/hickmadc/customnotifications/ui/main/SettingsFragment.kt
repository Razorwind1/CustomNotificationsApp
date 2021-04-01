package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.widget.ImageButton
import androidx.preference.PreferenceFragmentCompat
import edu.uc.hickmadc.customnotifications.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

}