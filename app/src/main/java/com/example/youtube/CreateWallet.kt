package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.ApiInterface
import com.example.youtube.databinding.ActivityCreateWalletBinding
import com.example.youtube.databinding.ActivityRegistrationBinding


class CreateWallet : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var binding: ActivityCreateWalletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val walletTitle: String = binding.walletTitle.text.toString()
        val walletDescription: String = binding.inputWalletDescription.text.toString()
        val walletBalance: String = binding.inputWalletBalance.text.toString()



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_wallet)
    }
}