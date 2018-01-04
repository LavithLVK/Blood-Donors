package com.example.lavithedam.blooddonors.activity.activity

import android.app.Activity
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import com.example.lavithedam.blooddonors.BloodCount
import com.example.lavithedam.blooddonors.R
import com.example.lavithedam.blooddonors.adapter.HomeGridAdapter

var mcurrentActivity: Activity? = null

fun setCurrentActivity(activity: Activity) {
    mcurrentActivity = activity
}

fun getCurrentActivity(): Activity? {
    return mcurrentActivity
}


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var homeGridContentList = arrayListOf<BloodCount>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setCurrentActivity(this)
        var homeGridView: GridView
        homeGridView = findViewById<GridView>(R.id.gridViewHome)
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        initializeGroupList()
        homeGridView.adapter = HomeGridAdapter(this, R.layout.grid_item_view, homeGridContentList)

    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_add_donor) {

        } else if (id == R.id.nav_view) {

        } else if (id == R.id.nav_about) {

        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun initializeGroupList() {
        homeGridContentList.add(BloodCount("A+", 0))
        homeGridContentList.add(BloodCount("A-", 0))
        homeGridContentList.add(BloodCount("B+", 0))
        homeGridContentList.add(BloodCount("B-", 0))
        homeGridContentList.add(BloodCount("AB+", 0))
        homeGridContentList.add(BloodCount("AB-", 0))
        homeGridContentList.add(BloodCount("O+", 0))
        homeGridContentList.add(BloodCount("O-", 0))
    }

}
