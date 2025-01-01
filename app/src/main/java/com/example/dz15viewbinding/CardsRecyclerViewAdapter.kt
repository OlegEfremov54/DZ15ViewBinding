package com.example.dz15viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dz15viewbinding.databinding.GridItemBinding

class CardsRecyclerViewAdapter(
    private val fragmentManager: FragmentManager,
    private val values: List<Item>
) : RecyclerView.Adapter<CardsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            GridItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.iconIV.setImageResource(item.iconResource)
        holder.titleTV.text = item.title

        holder.itemView.setOnClickListener {
            item.fragment.onClick(fragmentManager)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconIV: ImageView = binding.iconIv
        val titleTV: TextView = binding.titleTv
    }

}