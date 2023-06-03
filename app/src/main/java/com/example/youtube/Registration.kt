package com.example.youtube

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Registration : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        val regEmail = binding.registrationEmail.text.toString()
        val regPassword = binding.registrationPassword.text.toString()
        val firstName = binding.registrationFirstName.text.toString()
        val lastName = binding.registrationLastName.text.toString()
        val phone = binding.registrationPhone.text.toString()

        apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        CoroutineScope(Dispatchers.IO).launch {

//            Toast.makeText(thi, "", Toast.LENGTH_SHORT).show()

//            try {
//                val response = apiInterface.registration(regEmail , regPassword , firstName , lastName , phone)
//                Log.d("ayu: ", response.toString())
//                withContext(Dispatchers.Main) {
//                    if (response.isSuccessful) {
//                        val user = response.body()
//
////                        tokenDecoding(user?.access_token)
//                    } else {
//                        Toast.makeText(
//                            this@Registration,
//                            "Failed to get user: ${response.code()}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        this@Registration,
//                        "Error: ${e.message}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
        }


        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener {

//            val confirmPassword = binding.signupConfirmPassword.text.toString()


            if (regEmail.isNotEmpty() && regPassword.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && phone.isNotEmpty())
            {   this@Registration
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }else{
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                }


                binding.alreadyUser.setOnClickListener {
                    val loginIntent = Intent(this, Login::class.java)
                    startActivity(loginIntent)
                }
            }
        }
    }




