package com.example.youtube

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.models.RegistrationRequest
import com.example.retrofit.ApiInterface
import com.example.retrofit.RetrofitHelper
import com.example.youtube.databinding.ActivityLoginBinding
import com.example.youtube.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject


class Registration : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)

        binding.signupButton.setOnClickListener {
            val email = binding.registrationEmail.text.toString()
            val password = binding.registrationPassword.text.toString()
            val firstName = binding.registrationFirstName.text.toString()
            val lastName = binding.registrationLastName.text.toString()
            val phone = binding.registrationPhone.text.toString()

            Log.d("ayush: TestBindingInfo", "EMAIL: $email, PASSWORD: $password \n" +
                    "FIRSTNAME: $firstName, LASTNAME: $lastName, PHONE: $phone")

            if (email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this@Registration, "Some fields are empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = apiInterface.registration(RegistrationRequest(email, password, firstName, lastName, phone))
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@Registration,
                                "Registration successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            val loginPage = Intent(this@Registration, Login::class.java)
                            startActivity(loginPage)
                        } else {
                            val errorBody = response.errorBody()?.string()
                            val errorMessage = parseErrorMessage(errorBody)
                            Toast.makeText(
                                this@Registration,
                                "Failed registration: $errorMessage",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@Registration,
                            "Error: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding.alreadyUser.setOnClickListener {
            val loginPage = Intent(this, Login::class.java)
            startActivity(loginPage)
        }
    }
    private fun parseErrorMessage(errorBody: String?): String {
        try {
            val json = JSONObject(errorBody)
            val messages = json.getJSONArray("message")
            if (messages.length() > 0) {
                return messages.getString(0)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return "Unknown error"
    }
}





