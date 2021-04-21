package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.adapters.NotificationsAdapter
import edu.uc.hickmadc.customnotifications.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private val notificationViewModel: NotificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val notificationsAdapter = NotificationsAdapter()
        binding.apply {
            listView.apply {
                adapter = notificationsAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            fabAddNotif.setOnClickListener {

                findNavController().navigate(R.id.action_mainFragment_to_dialogPopupFragment)

            }
        }

        subscribeUi(notificationsAdapter)

        return binding.root
    }

    private fun subscribeUi(adapter: NotificationsAdapter) {
        notificationViewModel.notifications.observe(owner=viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}