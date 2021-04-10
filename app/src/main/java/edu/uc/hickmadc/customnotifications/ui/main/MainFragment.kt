package edu.uc.hickmadc.customnotifications.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import edu.uc.hickmadc.customnotifications.R
import androidx.fragment.app.viewModels


class MainFragment : Fragment() {


 //temp data
   private val language = arrayOf<String>("Brush Teeth","Eat Breakfast","Do schoolwork")
   private val description = arrayOf<String>(
        "Brush teeth for 2 minutes",
        "Eat so you don't feel like shit",
        "")
   private val days= arrayOf<String>("MWF","TFS","WTF")
   private val times= arrayOf<String>("1:30","13:15","8:30")

    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var viewModel: MainViewModel
    private val notificationViewModel: NotificationViewModel by viewModels(ownerProducer = { this })


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

          val addButton = view?.findViewById<ImageButton>(R.id.btnAdd)
                addButton?.setOnClickListener{
                    var dialog = DialogPopupFragment()

                    dialog.show(requireActivity().supportFragmentManager!!, "customdialog")
            }

        val lView= requireView().findViewById<ListView>(R.id.listView)
        val myListAdapter = MyListAdapter(requireActivity(),language,description,days, times)
        lView.adapter = myListAdapter

    }
     */

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val btnAdd = view?.findViewById<ImageButton>(R.id.btnAdd)
        btnAdd?.setOnClickListener {
            val dialog = DialogPopupFragment()
            dialog.show(childFragmentManager, "customDialog")
        }
    }
}