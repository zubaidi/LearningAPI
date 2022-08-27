package com.example.learningapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class DataItemAdapter(val list: ArrayList<GetDataAPI>) : RecyclerView.Adapter<DataItemAdapter.ViewHolder>() {
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(getDataAPI: GetDataAPI) {
            with(itemView) {
                idText.text = "ID : ${ getDataAPI.id.toString() }"
                judulText.text = "Judul : ${ getDataAPI.judul.toString() }"
                isiText.text = "Tulisan Random:\n${ getDataAPI.text.toString() }"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(
            R.layout.item_data, parent, false
        )
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}