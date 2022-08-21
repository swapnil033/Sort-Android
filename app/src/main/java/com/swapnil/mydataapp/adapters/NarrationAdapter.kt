package com.swapnil.mydataapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.mydataapp.databinding.RowNarrationHolderBinding
import com.swapnil.mydataapp.models.Narration

class NarrationAdapter(
    private val context : Context,
    private val list : ArrayList<Narration>
) : RecyclerView.Adapter<NarrationAdapter.NarretionTidHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NarretionTidHolder {
        val binding = RowNarrationHolderBinding.inflate(LayoutInflater.from(context), parent, false)

        return NarretionTidHolder(binding)
    }

    override fun onBindViewHolder(holder: NarretionTidHolder, position: Int) {
        holder.binding.data = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class NarretionTidHolder(val binding : RowNarrationHolderBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}