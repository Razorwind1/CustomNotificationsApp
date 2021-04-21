package edu.uc.hickmadc.customnotifications.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.uc.hickmadc.customnotifications.databinding.ListItemNotificationBinding
import edu.uc.hickmadc.customnotifications.dto.Notification

class NotificationsAdapter(private var onEdit: (Notification) -> Unit) :
    ListAdapter<Notification, NotificationsAdapter.NotificationViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding =
            ListItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding, onEdit)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class NotificationViewHolder(
        private val binding: ListItemNotificationBinding,
        private var onEdit: (Notification) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Notification) {
            binding.apply {
                title.text = item.title
                desc.text = item.desc
                active.isChecked = false
                time.text = item.time
                day.text = item.date
                grid.setOnClickListener {
                    onEdit(item)
                }
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