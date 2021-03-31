package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import edu.uc.hickmadc.customnotifications.R
import edu.uc.hickmadc.customnotifications.adapters.GroupsAdapter
import edu.uc.hickmadc.customnotifications.databinding.FragmentGroupsBinding
import edu.uc.hickmadc.customnotifications.dto.Group

class GroupsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentGroupsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val view = binding.root
//        context ?: return binding.root
        val groups: ArrayList<Group> = viewModel.getAllGroups()
        val adapter =
            GroupsAdapter(groups)
        with(binding) {
            groupList.adapter = adapter
            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.action_groupsFragment_to_groupsDialog)
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}