package com.example.youtube

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
import kotlinx.coroutines.GlobalScope
import retrofit2.HttpException
import java.io.IOException

class HomeView : AppCompatActivity() {
    private lateinit var binding: ActivityHomeViewBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var walletRvAdapter: WalletRvAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        GlobalScope.launch(Dispatchers.IO) {
//            val response = try {
//                RetrofitHelper.api.getMemes()
//
//            }catch (e: IOException){
//                Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_SHORT).show()
//                return@launch
//            }catch (e: HttpException){
//                Toast.makeText(applicationContext, "http error: ${e.message}", Toast.LENGTH_SHORT)
//                    .show()
//                return@launch
//            }
//            if (response.isSuccessful && response.body() != null){
//                withContext(Dispatchers.Main){
//                    val memesList: List<Meme> = response.body()!!.data.memes
//                    binding.apply {
//                        progressBar.visibility = View.GONE
//                        rvAdapter = RvAdapter(memesList)
//                        recyclerView.adapter = rvAdapter
//                        recyclerView.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
//                    }
//                }
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
}