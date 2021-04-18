package edu.uc.hickmadc.customnotifications.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.databinding.ListItemNotificationBinding
import edu.uc.hickmadc.customnotifications.dto.Notification

class NotificationsAdapter() :
    ListAdapter<Notification, NotificationsAdapter.NotificationViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding =
            ListItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class NotificationViewHolder(private val binding: ListItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

            binding.setClickListener { view ->
                Toast.makeText(view.context,"the notification is ${binding.title.text}",Toast.LENGTH_SHORT).show()
                findNavController(view).navigate(R.id.action_mainFragment_to_managePopupFragment)


            }
        }

        fun bind(item: Notification) {
            binding.apply {
                title.text = item.title
                subtext.text= item.subtext
                active.isChecked = false
                // TODO add the other fields
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Notification>() {
        override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean =
            oldItem.notificationId == newItem.notificationId

        override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean =
            oldItem == newItem
    }

}