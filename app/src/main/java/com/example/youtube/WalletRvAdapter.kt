package com.example.youtube

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.models.WalletData
import com.example.youtube.databinding.WalletItemBinding

class WalletRvAdapter(private val walletList: List<WalletData>): RecyclerView.Adapter<WalletRvAdapter.WalletViewHolder>() {
    class WalletViewHolder (val binding: WalletItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        return WalletViewHolder(WalletItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return walletList.size
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
