package com.example.youtube

import HistoryFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.ActivityHomeViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.youtube.databinding.ActivityMainBinding

class ExpenseHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeViewBinding
    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, HistoryFragment())
            commit()
        }

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
                    val intent = Intent(this, ExpenseHistoryActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit() }
}