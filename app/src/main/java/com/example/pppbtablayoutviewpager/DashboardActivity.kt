package com.example.pppbtablayoutviewpager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.pppbtablayoutviewpager.databinding.ActivityDashboardBinding
import com.example.pppbtablayoutviewpager.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityDashboardBinding.inflate(layoutInflater)

        title = "Dashboard"
        supportActionBar?.show()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding){
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_logout -> {
                val intentToMain = Intent(this@DashboardActivity, MainActivity::class.java)
                startActivity(intentToMain)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}