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
        if (position < mailList.size) {
            val mail = mailList[position]
            //Тема письма
            holder.holderBinding.mailTitleTv.text = mail.title
            //Тело письма
            holder.holderBinding.mailBodyTv.text = mail.body
            //Дата письма
            holder.holderBinding.mailDateTv.text = mail.date

            //Удаление из списка при длинном нажатие
            holder.itemView.setOnLongClickListener {
                mailList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, mailList.size)
                true
            }
        }
    }
    // Размер списка Писем
    override fun getItemCount(): Int = mailList.size

    inner class ViewHolder(binding: MailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val holderBinding = binding
    }

}