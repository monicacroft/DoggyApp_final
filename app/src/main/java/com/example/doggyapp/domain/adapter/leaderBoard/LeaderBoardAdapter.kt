package com.example.doggyapp.domain.adapter.leaderBoard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.doggyapp.R
import com.example.doggyapp.domain.entities.LeaderBoardData

class LeaderBoardAdapter(private val leaderBoardData:ArrayList<LeaderBoardData>):RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder>() {
    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
        val name: TextView = itemView.findViewById(R.id.textView3)
        val coins: TextView = itemView.findViewById(R.id.textView4)
        val rank: TextView = itemView.findViewById(R.id.rank)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            if (leaderBoardData[position].me){
                imageView.visibility = View.GONE
            }
            imageView.load(leaderBoardData[position].img){
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            name.text = leaderBoardData[position].name
            coins.text = leaderBoardData[position].coins
            rank.text = leaderBoardData[position].pos
        }


    }

    override fun getItemCount(): Int = leaderBoardData.size
}