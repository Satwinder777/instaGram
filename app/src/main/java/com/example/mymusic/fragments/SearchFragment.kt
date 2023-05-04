package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.VideoView
import android.widget.SearchView

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymusic.R
import com.example.mymusic.adapter.RecyclerAdapter4
import com.example.mymusic.dataClass.searchData


class SearchFragment : Fragment(),RecyclerAdapter4.OnStoryClick {
//    private  var videoView: VideoView?=null
    private lateinit var list: MutableList<searchData>
    private lateinit var adapter : RecyclerAdapter4
    var filteredlist: MutableList<searchData> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        videoView = view.findViewById(R.id.searchVideo)
//        videoView = view?.findViewById(R.id.videoView)!!

        val packageName = requireContext().packageName
         list = mutableListOf<searchData>(
            searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
             searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
             searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
             searchData("android.resource://" + packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + packageName + "/" + R.raw.video4,"gill"),

        )
        adapter = RecyclerAdapter4(requireContext(),list,this)
        val recycler :RecyclerView = view.findViewById(R.id.searchRecycler)
        recycler.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
        var searchView = view.findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                var filteredList1 = list.filter { it.videoName.contains(query.orEmpty(), true) }

                adapter.list = filteredList1 as MutableList
                Log.e("test1", "onQueryTextSubmit: onQueryTextSubmit", )
                adapter.notifyDataSetChanged()

//

                return true

            }

            override fun onQueryTextChange(query: String?): Boolean {
//                val filteredList = list.filter { !it.videoName.contains(query.orEmpty(), true) }
////                adapter.submitList(filteredList)
                adapter.list.clear()
//                adapter.notifyDataSetChanged()
                adapter.list = Data()
                Log.e("test1", "onQueryTextSubmit: onQueryTextChange", )
                return true

            }
        }
        )

        searchView.setOnCloseListener(object :SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                searchView.setQuery("", false)
                searchView.clearFocus()
                adapter.list.clear()
                adapter.list = SearchFragment().Data()
                adapter.notifyDataSetChanged()
                Log.e("test1", "onClose:  closed tagged listner using kotlin", )

                return true
            }

        })



    }
    var a = true

    override fun onClickStory(position: Int,view: VideoView) {
        if (view.isPlaying) {
            view.pause()
        } else {
            view.start()
        }

    }
//    @SuppressLint("NotifyDataSetChanged")
//    private fun filter(text: String) {
//        // creating a new array list to filter our data.
////        val filteredlist: ArrayList<CourseRVModal> = ArrayList()
//
//        // running a for loop to compare elements.
//        for (item in list) {
//            // checking if the entered string matched with any item of our recycler view.
//            if (item.videoName.toLowerCase().contains(text.toLowerCase())) {
//                // if the item is matched we are
//                // adding it to our filtered list.
//                filteredlist.add(item)
//            }
//        }
//        if (filteredlist.isEmpty()) {
//            // if no item is added in filtered list we are
//            // displaying a toast message as no data found.
//            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
//        } else {
//            // at last we are passing that filtered
//            // list to our adapter class.
//            adapter.list = filteredlist
//            adapter.notifyDataSetChanged()
//        }
//    }

     fun Data():MutableList<searchData>{
        list = mutableListOf<searchData>(
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video1,"satta"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video3,"sher"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),
            searchData("android.resource://" + requireContext().packageName + "/" + R.raw.video4,"gill"),

            )
        return list
    }

}