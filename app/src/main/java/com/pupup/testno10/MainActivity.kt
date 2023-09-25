package com.pupup.testno10

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val show_navigation : ImageView = findViewById(R.id.show_navigation)
        val drawerLayout : DrawerLayout = findViewById(R.id.drawable_layout)
        val navigationView : NavigationView = findViewById(R.id.navigation_item)

        show_navigation.setOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(this,"Clicked Home" ,Toast.LENGTH_SHORT).show()
                R.id.message -> Toast.makeText(this,"Clicked Message" ,Toast.LENGTH_SHORT).show()
                R.id.sync -> Toast.makeText(this,"Clicked Sync" ,Toast.LENGTH_SHORT).show()
                R.id.logIn -> Toast.makeText(this,"Clicked Login" ,Toast.LENGTH_SHORT).show()
                R.id.share -> Toast.makeText(this,"Clicked Share" ,Toast.LENGTH_SHORT).show()
                R.id.rate -> Toast.makeText(this,"Clicked Rating" ,Toast.LENGTH_SHORT).show()
            }
            true
        }

        val more_vert : ImageView = findViewById(R.id.more_vert)
        more_vert.setOnClickListener {
            val layout = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout,null,false)

            val dialog = BottomSheetDialog(this)
            dialog.setContentView(layout)
            dialog.show()
        }
        loadFragment(HomeFragment())
        val bottom_navigation : BottomNavigationView = findViewById(R.id.bottom_navigation_item)
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->loadFragment(HomeFragment())
                R.id.add_student->loadFragment(StudentFragment())
                R.id.fee_list->loadFragment(FeeAddFragment())
                R.id.setting->loadFragment(SettingFragment())
            }
            true
        }
    }
    fun loadFragment(fragment: Fragment){
        val fragment = supportFragmentManager.beginTransaction().replace(R.id.frame_layout,fragment).commit()
    }
}