package com.example.youtube

import HistoryFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.fragment.app.Fragment
import com.example.youtube.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    fun Carousel(view: View) {
        val carPage = Intent(this, Carousel::class.java)
        startActivity(carPage)
        finish()
    }


    fun onReceive(context: Context, intent: Intent?) {
        val startActivity = Intent()
        startActivity.setClass(context, Carousel::class.java)
        startActivity.action = Carousel::class.java.getName()
        startActivity.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        context.startActivity(startActivity)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        val button = findViewById<View>(R.id.bottom_nav)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val intent = Intent(this, HomeView::class.java)
                    startActivity(intent)
                }
                R.id.settings -> {
                    replaceFragment(SettingsFragment())
                }
                R.id.history -> {
                    replaceFragment(HistoryFragment())
                }
            }
            true
        }




    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container,fragment)
        fragmentTransaction.commit()
    }

}