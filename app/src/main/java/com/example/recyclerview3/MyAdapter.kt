package com.example.recyclerview3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.collection.intIntMapOf
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private  val userArray : ArrayList<MyDataClass>)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

          lateinit var   myListener: OnItemClickListener
            interface  OnItemClickListener{
                  fun   onItemClick(position: Int)
            }
      fun   setOnItemClickListener(listener: OnItemClickListener)  {
            myListener =  listener
      }
    class MyViewHolder(itemView: View , listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
         val image : ImageView  =  itemView.findViewById(R.id.image_Id)
         val names : TextView  =  itemView.findViewById(R.id.name_Id)

        init {
            itemView.setOnClickListener {
                  listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view =  LayoutInflater.from(parent.context).inflate(R.layout.itemview  , parent , false)
         return   MyViewHolder(view , myListener)
    }

    override fun getItemCount(): Int {
    return  userArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedItem =  userArray[position]
           holder.image.setImageResource(selectedItem.image)
         holder.names.text =  selectedItem.name
    }
}