package com.example.doggyapp.domain.adapter.avatar

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import coil.transform.CircleCropTransformation
import com.example.doggyapp.R
import com.example.doggyapp.domain.entities.Avatars
import kotlinx.android.synthetic.main.fragment_avatar.view.*

var avatar:Int = R.drawable.avatar1
var totalCount:Int = 40
class ImageAdapter(private val imageList: ArrayList<Avatars>, private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView);
        val imageViewLock: ImageView = itemView.findViewById(R.id.lock);
        val textView:TextView = itemView.findViewById(R.id.text);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        holder.imageView.setImageResource(imageList[position])
        if (totalCount < imageList[position].count){
            holder.imageViewLock.visibility = View.VISIBLE
            holder.itemView.isClickable = false
            holder.itemView.rootView.isClickable = false
        }
        if (avatar == imageList[position].img){
            holder.itemView.setBackgroundResource(R.drawable.slected_drawable)
        }else{
            holder.itemView.setBackgroundResource(R.drawable.background_item)
        }
        holder.imageView.load(imageList[position].img){
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        holder.textView.text = "${imageList[position].name}  ${imageList[position].count}"


        holder.itemView.setOnClickListener {
            avatar = imageList[position].img
            if (position == 0) notifyItemChanged(1) else notifyItemChanged(0)
            holder.itemView.setBackgroundResource(R.drawable.slected_drawable)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}