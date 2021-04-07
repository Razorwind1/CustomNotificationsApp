package edu.uc.hickmadc.customnotifications.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import edu.uc.hickmadc.customnotifications.databinding.DialogGroupsBinding
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.ui.main.MainViewModel

class GroupsDialog : BottomSheetDialogFragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: DialogGroupsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogGroupsBinding.inflate(inflater, container, false)
        binding.btnConfirm.setOnClickListener {
            val response = viewModel.createGroup(
                Group(
                    binding.txtName.text.toString(),
                    binding.txtDesc.text.toString(),
                    active = true,
                    same_schedule = true
                )
            )
            when (response) {
                0 -> findNavController().navigateUp()
                1 -> Toast.makeText(
                    context,
                    "Error: Group could not be created",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}