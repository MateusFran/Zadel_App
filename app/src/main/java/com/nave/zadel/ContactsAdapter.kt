package com.nave.zadel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactsAdapter(var list:List<ContactData>) : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, pos: Int) {
        holder.name.text = list[pos].name
        holder.status.text = list[pos].status
    }


    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name = itemView.contact_name
        var status = itemView.contact_status
    }
}