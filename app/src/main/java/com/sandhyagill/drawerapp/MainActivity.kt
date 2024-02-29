package com.sandhyagill.drawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.sandhyagill.drawerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navController = findNavController(R.id.fragment)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
            R.string.open_drawer, R.string.close_drawer)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        override fun onSupportNavigateUp(): Boolean {

            if (binding.drawerLayout.isDrawerOpen(binding.sideNavigation)) {
                binding.drawerLayout.closeDrawer(binding.sideNavigation)
            } else {
                onBackPressed()
            }
            return true
        }

        binding.sideNavigation.setNavigationItemSelectedListener {
            when(it.itemId){
               R.id.menuProfile->{
                   navController.navigate(R.id.profileFragment)
                   Toast.makeText(this,resources.getString(R.string.profile), Toast.LENGTH_SHORT).show()
               }
                R.id.menuUploadProduct->{
                   navController.navigate(R.id.uploadProductFragment)
                   Toast.makeText(this, resources.getString(R.string.upload_product), Toast.LENGTH_SHORT).show()
               }
                R.id.menuEditProduct->{
                   Toast.makeText(this, resources.getString(R.string.edit_product), Toast.LENGTH_SHORT).show()
               }
                R.id.menuDeleteProduct->{
                   Toast.makeText(this, resources.getString(R.string.delete_product), Toast.LENGTH_SHORT).show()
               }
                R.id.menuOrderReceived->{
                   Toast.makeText(this, resources.getString(R.string.order_received), Toast.LENGTH_SHORT).show()
               }
                R.id.menuUnpaidOrder->{
                   Toast.makeText(this, resources.getString(R.string.unpaid_order), Toast.LENGTH_SHORT).show()
               }
                R.id.menuHistory->{
                   Toast.makeText(this, resources.getString(R.string.history), Toast.LENGTH_SHORT).show()
               }
            }
            binding.drawerLayout.closeDrawers()
            return@setNavigationItemSelectedListener true
        }


    }
//    override fun onSupportNavigateUp(): Boolean {
//
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}