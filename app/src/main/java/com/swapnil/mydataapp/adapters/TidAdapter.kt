package com.swapnil.mydataapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.mydataapp.databinding.RowTidHolderBinding
import com.swapnil.mydataapp.models.TidData

class TidAdapter(
    private val context : Context,
    private val tidList : ArrayList<TidData>
) : RecyclerView.Adapter<TidAdapter.TidHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TidHolder {
        val binding = RowTidHolderBinding.inflate(LayoutInflater.from(context), parent, false)

        return TidHolder(binding)
    }

    override fun onBindViewHolder(holder: TidHolder, position: Int) {
        holder.binding.data = tidList[position]
        holder.binding.adapter = NarrationAdapter(context, tidList[position].sortNarration)
    }

    override fun getItemCount(): Int {
        return tidList.size
    }


    class TidHolder(val binding : RowTidHolderBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}