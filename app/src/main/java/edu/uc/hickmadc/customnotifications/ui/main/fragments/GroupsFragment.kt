package edu.uc.hickmadc.customnotifications.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import edu.uc.hickmadc.customnotifications.databinding.FragmentGroupsBinding
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.ui.main.MainViewModel
import edu.uc.hickmadc.customnotifications.ui.main.adapters.GroupsAdapter
import java.util.ArrayList

class GroupsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentGroupsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val view = binding.root
//        context ?: return binding.root
        val groups: ArrayList<Group> = viewModel.getAllGroups()
        val adapter =
            GroupsAdapter(
                groups
            )
        with(binding) {
            groupList.adapter = adapter
            fabAdd.setOnClickListener { viewModel.exampleClick() }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}