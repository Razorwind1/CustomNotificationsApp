package edu.uc.hickmadc.customnotifications.ui.main

import android.app.AlarmManager
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.compose.navArgument
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.databinding.NotificationDialogBinding
import edu.uc.hickmadc.customnotifications.dto.Notification
import edu.uc.hickmadc.customnotifications.service.AlarmService
import java.lang.Integer.parseInt
import java.util.*
import java.util.logging.Logger

@AndroidEntryPoint
class DialogPopupFragment : DialogFragment(), AdapterView.OnItemSelectedListener {

    private val notificationViewModel: NotificationViewModel by viewModels()
    private lateinit var alarmService: AlarmService

    private var _binding: NotificationDialogBinding? = null

    private val binding get() = _binding!!

    private var interval = "Never"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {



        _binding = NotificationDialogBinding.inflate(inflater, container, false)
        context ?: return binding.root
        alarmService = AlarmService(requireContext())

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.interval_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnInterval.adapter = adapter
        }
        binding.apply {
            btnClose.setOnClickListener {
                findNavController().navigateUp()
            }
            btnConfirm.setOnClickListener {
                saveNotification(
                    binding.txtTitle.text.toString(),
                    binding.txtDescription.text.toString()
                )
                findNavController().navigateUp()
            }
            editTextDate.setText(DateFormat.format("MM/dd/yyyy", Calendar.getInstance()))
            editTextTime.setText(DateFormat.format("HH:mm", Calendar.getInstance()))
        }
        return binding.root
    }

    private fun saveNotification(title: String, desc: String) {
        val notif = Notification(title, "", desc)
        val now = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }
        val dateText = binding.editTextDate.text.toString().split("/")
        val timeText = binding.editTextTime.text.toString().split(":")
        val triggerDate: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.MONTH, parseInt(dateText[0]) - 1)
            set(Calendar.DAY_OF_MONTH, parseInt(dateText[1]))
            set(Calendar.YEAR, parseInt(dateText[2]))
            set(Calendar.HOUR_OF_DAY, parseInt(timeText[0]))
            set(Calendar.MINUTE, parseInt(timeText[1]))
            set(Calendar.SECOND, 0)
        }

        // only schedule with system if scheduled for today
        if (triggersToday(triggerDate, now)) {
            when (interval) {
                "Never" -> {
                    Logger.getAnonymousLogger()
                        .warning((triggerDate.timeInMillis - now.timeInMillis).toString())
                    alarmService.setSingleAlarm(
                        (triggerDate.timeInMillis - now.timeInMillis),
                        notif
                    )
                }
                "Hourly" -> {
                    alarmService.setInexactRepeatingAlarm(
                        notif,
                        System.currentTimeMillis(),
                        AlarmManager.INTERVAL_HOUR
                    )
                }
                "Daily" -> {
                    alarmService.setInexactRepeatingAlarm(
                        notif,
                        System.currentTimeMillis(),
                        AlarmManager.INTERVAL_DAY
                    )
                }

                "Weekly" -> {
                    TODO()
                }
                "Monthly" -> {
                    TODO()
                }
                "Yearly" -> {
                    TODO()
                }
            }
        }
        notificationViewModel.saveNotification(Notification(title, "", desc))
    }

    private fun triggersToday(triggerDate: Calendar, currentDate: Calendar): Boolean {
        val triggerMonth = DateFormat.format("MM", triggerDate) as String
        val currentMonth = DateFormat.format("MM", currentDate) as String
        val triggerDay = DateFormat.format("dd", triggerDate) as String
        val currentDay = DateFormat.format("dd", currentDate) as String
        val triggerYear = DateFormat.format("yyyy", triggerDate) as String
        val currentYear = DateFormat.format("yyyy", currentDate) as String

        return (triggerMonth == currentMonth) && (triggerDay == currentDay) && (currentYear == triggerYear)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        interval = parent.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        interval = "Never"
    }
}
