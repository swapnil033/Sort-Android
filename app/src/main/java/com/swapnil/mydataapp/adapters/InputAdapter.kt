package com.swapnil.mydataapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swapnil.mydataapp.databinding.RowDataHolderBinding
import com.swapnil.mydataapp.models.Data1

class InputAdapter(
    private val context : Context,
    private val sort : ArrayList<Data1>
    ) : RecyclerView.Adapter<InputAdapter.InputHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputHolder {
        val binding = RowDataHolderBinding.inflate(LayoutInflater.from(context), parent, false)

        return InputHolder(binding)
    }

    override fun onBindViewHolder(holder: InputHolder, position: Int) {
        holder.binding.data = sort[position]
        holder.binding.adapter = TidAdapter(context, sort[position].tidList)

        holder.itemView.setOnClickListener {
            onClick(holder)
        }
        holder.itemView.setOnClickListener {
            onClick(holder)
        }
    }


    private fun onClick(holder: InputHolder) {
        if (holder.binding.groupExpanded.visibility == View.VISIBLE) {
            holder.binding.groupExpanded.visibility = View.GONE
            holder.binding.tvCollapsed.visibility = View.VISIBLE
        } else {
            holder.binding.groupExpanded.visibility = View.VISIBLE
            holder.binding.tvCollapsed.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return sort.size
    }


    class InputHolder(var binding: RowDataHolderBinding) : RecyclerView.ViewHolder(binding.root)
}