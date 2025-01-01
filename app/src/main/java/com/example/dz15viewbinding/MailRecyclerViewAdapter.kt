package com.example.dz15viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz15viewbinding.databinding.MailItemBinding

class MailRecyclerViewAdapter(
    private val mailList: MutableList<Mail>
) : RecyclerView.Adapter<MailRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            MailItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mail = mailList[position]
        holder.holderBinding.mailTitleTv.text = mail.title
        holder.holderBinding.mailBodyTv.text = mail.body
        holder.holderBinding.mailDateTv.text = mail.date

        holder.itemView.setOnLongClickListener {
            mailList.removeAt(position)
            notifyItemRemoved(position)
            true
        }
    }

    override fun getItemCount(): Int = mailList.size

    inner class ViewHolder(binding: MailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val holderBinding = binding
    }

}