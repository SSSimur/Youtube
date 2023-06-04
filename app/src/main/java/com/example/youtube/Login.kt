package com.example.youtube

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.models.LoginRequest
import com.example.models.User
import com.example.preferences.SharedPreferences
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.ActivityLoginBinding

import com.util.utils.SECRET_KEY
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.crypto.SecretKey


open class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinButton.setOnClickListener{
            val email = binding.signinEmail.text.toString()
            val password = binding.signinPassword.text.toString()
//            Log.d("ayush: ","I am tauks")
//            Log.d("testemail: ",email)

//            binding.
            prefs = SharedPreferences(this);
            apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
            CoroutineScope(Dispatchers.IO).launch {
//                val message: String? = apiInterface.test().toString()
//                    Log.d("tauks:", message.toString())
//                if (message != null) {
//                    Toast.makeText(this@Login, message, Toast.LENGTH_SHORT).show()
//                }
//            }
//                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                try {
                    val response = apiInterface.login(LoginRequest(email, password))
                    Log.d("ayush: RequestString", LoginRequest(email, password).toString())
                    Log.d("ayush: Response", response.toString())
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            val user = response.body()
                            Log.d("ayush: UserInfo", user.toString())
                            prefs.recieveToken(user!!.access_token)
                            val homePage = Intent(this@Login, MainActivity::class.java)
                            startActivity(homePage)
                            finish()

                        } else {
                            Toast.makeText(
                                this@Login,
                                "Failed to get user: ${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@Login,
                            "Error: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }


    //         kuat@gmail.com
    //         qwerty


    //Caching the token




    fun createacc(view: View) {
        val nextPage = Intent(this, Registration::class.java)
        startActivity(nextPage)
        finish()
    }


}
