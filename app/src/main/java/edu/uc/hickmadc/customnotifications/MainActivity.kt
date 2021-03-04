package edu.uc.hickmadc.customnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.uc.hickmadc.customnotifications.ui.main.MyListAdapter

class MainActivity : AppCompatActivity() {

    //temp data
    private val language = arrayOf<String>("Brush Teeth","Eat Breakfast","Do schoolwork")
    private val description = arrayOf<String>(
        "Brush teeth for 2 minutes",
        "Eat so you don't feel like shit",
        "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lView= findViewById<ListView>(R.id.listView)
        val myListAdapter = MyListAdapter(this,language,description)
        lView.adapter = myListAdapter
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
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