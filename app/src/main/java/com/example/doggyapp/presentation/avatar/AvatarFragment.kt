package com.example.doggyapp.presentation.avatar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.doggyapp.R
import com.example.doggyapp.domain.adapter.avatar.ImageAdapter
import com.example.doggyapp.domain.adapter.avatar.totalCount
import com.example.doggyapp.domain.entities.Avatars
import kotlinx.android.synthetic.main.fragment_avatar.*
import java.lang.Math.abs

class AvatarFragment : Fragment(R.layout.fragment_avatar) {

    private lateinit var handler : Handler
    private lateinit var avatarList:ArrayList<Avatars>
    private lateinit var adapter: ImageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpUi()
    }
    private fun setUpUi(){
        init()
        setUpTransformer()
    }


    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(){
        coins.text = totalCount.toString()
        handler = Handler(Looper.myLooper()!!)
        avatarList = ArrayList()

        avatarList.add(Avatars(R.drawable.avatar1,"doggy",20))
        avatarList.add(Avatars(R.drawable.avatar2,"jdroho",40))
        avatarList.add(Avatars(R.drawable.avatar3,"snobi",50))
        avatarList.add(Avatars(R.drawable.avataw4,"sano",60))
        avatarList.add(Avatars(R.drawable.avatar5,"aslana",100))
        avatarList.add(Avatars(R.drawable.avatar6,"davita",150))
        avatarList.add(Avatars(R.drawable.avatar7,"ruslana",200))

        adapter = ImageAdapter(avatarList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

}