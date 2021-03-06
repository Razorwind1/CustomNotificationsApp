package edu.uc.hickmadc.customnotifications.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.uc.hickmadc.customnotifications.databinding.ListItemGroupBinding
import edu.uc.hickmadc.customnotifications.dto.Group


class GroupsAdapter(private val dataSet: ArrayList<Group>) :
    ListAdapter<Group, RecyclerView.ViewHolder>(GroupDiffCallback()) {

    /**
     * Creates list rows / views
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GroupViewHolder(
            ListItemGroupBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * Gets a group from dataSet and bind it to the empty viewHolder
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GroupViewHolder).bind(dataSet[position])
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataSet.size

    class GroupViewHolder(private val binding: ListItemGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Group) {
            binding.apply {
                group = item
                executePendingBindings()
            }
        }
    }

    /**
     * Handles the comparison between groups.
     */
    private class GroupDiffCallback : DiffUtil.ItemCallback<Group>() {

        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.groupId == newItem.groupId
        }

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem == newItem
        }
    }
}

