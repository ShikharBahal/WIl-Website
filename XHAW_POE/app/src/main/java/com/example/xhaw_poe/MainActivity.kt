package com.example.xhaw_poe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.six_week -> {
                    replaceFragment(Six_week_Fragment())
                    true
                }


                R.id.six_month -> {
                    replaceFragment(six_Month_fragment())
                    true
                }


                R.id.Cart -> {
                    replaceFragment(Cart_Fragment())
                    true
                }


                R.id.contact_infomation -> {
                    replaceFragment(Contact_Fragment())
                    true
                }

                R.id.log_out -> {
                    replaceFragment(Logout_Fragment())
                    true
                }



                else -> false
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set default fragment
        replaceFragment(Six_week_Fragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, fragment).commit()
    }
}
