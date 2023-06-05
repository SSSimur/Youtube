package com.example.youtube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.models.WalletData
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.ActivityHomeViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.youtube.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import retrofit2.HttpException
import java.io.IOException
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import com.example.models.AllWalletData
import com.example.models.LoginRequest
import com.example.models.LoginResponse
import com.example.models.User


class HomeView : AppCompatActivity() {
    private lateinit var binding: ActivityHomeViewBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var walletRvAdapter: WalletRvAdapter


    @OptIn(DelicateCoroutinesApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val response = apiInterface.getWallets()
//                binding.apply {
//                    progressBar.visibility = View.GONE
//                    walletRvAdapter = WalletRvAdapter(walletList)
//                }
//                if (response.isSuccessful && response.body() != null) {
//                    val walletData :List<WalletData> = response.body()!!
//                }
//            } catch (e: HttpException) {
//            }
//        }




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

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit() }

    fun EditProfileData(view: View) {
        val intent = Intent(this, EditProfile::class.java)
        startActivity(intent)
    }

    fun create_wallet_button(view: View) {
        val intent = Intent(this, CreateWallet::class.java)
        startActivity(intent)
    }
}