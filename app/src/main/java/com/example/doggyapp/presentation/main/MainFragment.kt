package com.example.doggyapp.presentation.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.example.doggyapp.R
import com.example.doggyapp.domain.adapter.avatar.avatar
import com.example.doggyapp.domain.adapter.avatar.totalCount
import com.example.doggyapp.domain.adapter.leaderBoard.LeaderBoardAdapter
import com.example.doggyapp.domain.entities.LeaderBoardData
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpUi()
    }
    private fun setUpUi(){
        coinsMain.text = totalCount.toString()

        firstPlace.load(R.drawable.avatar6){
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        secondPlace.load(R.drawable.avatar3){
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        thirdPlace.load(R.drawable.avatar7){
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        val leaderBoardData:ArrayList<LeaderBoardData> = ArrayList()
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar2,"bondo","rank:4", "250",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar3,"gordo","rank:5", "240",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar5,"dzia","rank:6", "210",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar1,"beli","rank:7", "200",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar2,"what","rank:8","190",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar1,"hot","rank:9", "180",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar6,"not","rank:10", "160",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar2,"what","rank:11","190",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar1,"hot","rank:12", "180",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar6,"not","rank:13", "160",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar2,"what","rank:14","190",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar1,"hot","rank:15", "180",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar6,"not","rank:16", "160",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar2,"what","rank:17","190",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar1,"hot","rank:18", "180",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar6,"not","rank:19", "160",false))
        leaderBoardData.add(LeaderBoardData(R.drawable.avatar6,"not","rank:20", "160",false))
        leaderboard.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        leaderboard.adapter = LeaderBoardAdapter(leaderBoardData)
    }
}