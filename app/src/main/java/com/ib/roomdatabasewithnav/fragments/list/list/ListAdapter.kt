package com.ib.roomdatabasewithnav.fragments.list.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ib.roomdatabasewithnav.R
import com.ib.roomdatabasewithnav.data.Person
import kotlinx.android.synthetic.main.my_template.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    var personList = emptyList<Person>()

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.my_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = personList[position]
        holder.itemView.tvId.text = currentItem.id.toString()
        holder.itemView.tvFirstName.text = currentItem.firstName
        holder.itemView.tvLastName.text = currentItem.lastName
        holder.itemView.tvAge.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun setData(person: List<Person>){
this.personList = person
        notifyDataSetChanged()
    }
}