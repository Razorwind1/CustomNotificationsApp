package edu.uc.hickmadc.customnotifications

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.uc.hickmadc.customnotifications.ui.main.MyListAdapter
import edu.uc.hickmadc.customnotifications.ui.main.dialogfragment

class MainActivity : AppCompatActivity() {






    //temp data
    val language = arrayOf<String>("Brush Teeth","Eat Breakfast","Do schoolwork")
    val description = arrayOf<String>(
        "Brush teeth for 2 minutes",
        "Eat so you don't feel like shit",
        "")
    val days= arrayOf<String>("MWF","TFS","WTF")
    val times= arrayOf<String>("1:30","13:15","8:30")

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val lView= findViewById<ListView>(R.id.listView)
        val myListAdapter = MyListAdapter(this,language,description,days, times)
        lView.adapter = myListAdapter
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        val addButton = findViewById<ImageButton>(R.id.btnAdd)
        addButton.setOnClickListener{
        var dialog= dialogfragment()

        dialog.show(supportFragmentManager, "customdialog")


        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}