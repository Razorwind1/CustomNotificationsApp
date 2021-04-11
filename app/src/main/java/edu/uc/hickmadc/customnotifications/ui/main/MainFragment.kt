package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.uc.hickmadc.customnotifications.adapters.NotificationsAdapter
import edu.uc.hickmadc.customnotifications.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
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
            btnAdd.setOnClickListener {
                DialogPopupFragment()
                    .show(requireActivity().supportFragmentManager, "customdialog")
            }
            listView.apply {
                adapter = notificationsAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        subscribeUi(notificationsAdapter)

        return binding.root
    }

    private fun subscribeUi(adapter: NotificationsAdapter) {
        notificationViewModel.notifications.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}