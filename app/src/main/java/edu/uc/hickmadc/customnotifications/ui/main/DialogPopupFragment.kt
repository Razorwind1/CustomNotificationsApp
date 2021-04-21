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

    private enum class EditingState {
        NEW_NOTIF,
        EXISTING_NOTIF
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = NotificationDialogBinding.inflate(inflater, container, false)
        context ?: return binding.root
        alarmService = AlarmService(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var notification: Notification? = null
        val args: DialogPopupFragmentArgs by navArgs()
        val editingState =
            if (args.notificationId > 0) EditingState.EXISTING_NOTIF
            else EditingState.NEW_NOTIF

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.interval_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnInterval.adapter = adapter
        }

        if (editingState == EditingState.EXISTING_NOTIF) {
            // Request to edit an existing item, whose id was passed in as an argument.
            // Retrieve that item and populate the UI with its details
            notificationViewModel.get(args.notificationId)
                .observe(viewLifecycleOwner) { notificationItem ->
                    binding.txtTitle.setText(notificationItem.title)
                    binding.txtDescription.setText(notificationItem.desc)
                    binding.editTextDate.setText(notificationItem.date)
                    binding.editTextTime.setText(notificationItem.time)
                    //TODO: set spinner value.
                    notification = notificationItem
                }
            binding.btnConfirm.setOnClickListener {
                notificationViewModel.updateNotification(
                    Notification(
                        title = binding.txtTitle.text.toString(),
                        desc = binding.txtDescription.text.toString(),
                        date = binding.editTextDate.text.toString(),
                        time = binding.editTextTime.text.toString(),
                        interval = interval,
                        notificationId = args.notificationId
                    )
                )
                findNavController().navigateUp()
            }
        } else {
            with(binding) {
                btnConfirm.setOnClickListener {
                    saveNotification(
                        binding.txtTitle.text.toString(),
                        binding.txtDescription.text.toString(),
                        binding.editTextDate.text.toString(),
                        binding.editTextTime.text.toString(),
                        interval
                    )
                    findNavController().navigateUp()
                }
                editTextDate.setText(DateFormat.format("MM/dd/yyyy", Calendar.getInstance()))
                editTextTime.setText(DateFormat.format("HH:mm", Calendar.getInstance()))
            }
        }

        binding.apply {
            btnClose.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun saveNotification(
        title: String,
        desc: String,
        date: String,
        time: String,
        interval: String
    ) {
        val notification =
            Notification(title = title, desc = desc, date = date, time = time, interval = interval)
        val now = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }
        val dateParts = date.split("/")
        val timeParts = time.split(":")
        val triggerDate: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.MONTH, parseInt(dateParts[0]) - 1)
            set(Calendar.DAY_OF_MONTH, parseInt(dateParts[1]))
            set(Calendar.YEAR, parseInt(dateParts[2]))
            set(Calendar.HOUR_OF_DAY, parseInt(timeParts[0]))
            set(Calendar.MINUTE, parseInt(timeParts[1]))
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
                        notification
                    )
                }
                "Hourly" -> {
                    alarmService.setInexactRepeatingAlarm(
                        notification,
                        System.currentTimeMillis(),
                        AlarmManager.INTERVAL_HOUR
                    )
                }
                "Daily" -> {
                    alarmService.setInexactRepeatingAlarm(
                        notification,
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
        notificationViewModel.saveNotification(notification)
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
