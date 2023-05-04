package com.example.mymusic.fragments

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymusic.R
import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*

import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.example.mymusic.activity.StoryActivity
import com.example.mymusic.adapter.PageAdapter
import com.example.mymusic.adapter.RecyclerAdapter
import com.example.mymusic.adapter.RecyclerAdapter2
import com.example.mymusic.adapter.ShareAdapter
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.databinding.ActivityMainBinding
import com.example.mymusic.databinding.FragmentMainBinding
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import com.example.taskviewpager.pageadapter.MainPageAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment(), RecyclerAdapter2.OnClickBottom,
    ShareAdapter.OnShareClick, RecyclerAdapter.OnStoryClick {

    private lateinit var binding: FragmentMainBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var adapterb: ShareAdapter
    private lateinit var recyclerViewb: RecyclerView
    lateinit var list2b: MutableList<Unsplaceapi>
    private lateinit var list: MutableList<Unsplaceapi>
    lateinit var list2: MutableList<Unsplaceapi>
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var sendbtn: Button
    var a = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_main, container, false)


    }

    @SuppressLint("MissingInflatedId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rv2


        var bottomSheet = view.findViewById<ConstraintLayout>(R.id.linearLayout12)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE
        recyclerView2 = binding.recyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager = LinearLayoutManager(context)
        list = mutableListOf()
        list2 = mutableListOf()

        var adapter = RecyclerAdapter(requireContext(), list, this)
        var adapter2 = RecyclerAdapter2(requireContext(), list2, this)

        var request = Helper.getResp()
        var interface1 = request.create(uspInterface::class.java)
        interface1.getImage()
        var call: Call<Unsplaceapi> = interface1.getImage()
//        val call: Call<QuoteList> = quotesApi.getQuote()

        call.enqueue(object : Callback<Unsplaceapi> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
                if (response.isSuccessful) {


//                    list.add(response.)
                    progressBar.visibility = View.INVISIBLE

                    for (result in 1..response.body()?.size!!) {
                        list.add(response.body()!!)
                        list2.add(response.body()!!)
                    }
                    Log.e("resp", "onResponse: ${response.body()}")
                }
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                adapter2.notifyDataSetChanged()
                recyclerView2.adapter = adapter2
            }

            override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
                Toast.makeText(requireContext(), "failure", Toast.LENGTH_SHORT).show()
            }

        })
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@MainActivity, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText( this@MainActivity, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@MainActivity, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@MainActivity, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@MainActivity, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(requireContext(), "OTHER_STATE", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                Toast.makeText(this@MainActivity, "toast", Toast.LENGTH_SHORT).show()
            }
        })

        recyclerViewb = view.findViewById(R.id.shareRecycler)
        list2b = mutableListOf()
        adapterb = ShareAdapter(requireContext(), list2b, this)


        var callbs = Helper.getResp()
        var final = callbs.create(uspInterface::class.java)
        var last: Call<Unsplaceapi> = final.getImage()

        last.enqueue(object : Callback<Unsplaceapi> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
                var data = response?.body()!!
                for (mydata in 0..data.size - 1) {
                    list2b.add(data)
                    adapterb.notifyDataSetChanged()
                    recyclerViewb.adapter = adapterb

                }
            }

            override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
                Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
            }

        })

        sendbtn = view.findViewById<Button>(R.id.btn_send)
        sendbtn.visibility = View.INVISIBLE
        sendbtn.setOnClickListener {

            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

            }
        }
        binding.mainShare.setOnClickListener {
            binding.mainShare
                .setOnClickListener {

                    val viewPager = requireActivity().findViewById<ViewPager>(R.id.viewPage0)
                    viewPager.currentItem = 2

                }
        }
        var window = PopupWindow(requireContext())
        var view1 = layoutInflater.inflate(R.layout.following_popup, null)
        window.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.custom_popup_bg
            )
        )
        binding.InstaText.setOnClickListener {
            window.contentView = view1
            window.showAsDropDown(it)
        }

       var following = view1.findViewById<LinearLayout>(R.id.followingLine)
        following.setOnClickListener { window.dismiss()
        }

        var favorate = view1.findViewById<LinearLayout>(R.id.favorateLine)
        favorate.setOnClickListener { window.dismiss()
        }
    }
    override fun onClickShare(position: Int) {
        Log.e("position", "onClickShare: postion is :$position")
        if (sendbtn.isVisible.not()) {
            sendbtn.visibility = View.VISIBLE
        } else {
            sendbtn.visibility == View.GONE
        }


    }

    override fun onClickBottomSheet(unsplaceapi: Unsplaceapi) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        }
    }

    override fun onClickStory(position: Int) {
        val intent = Intent(requireContext(), StoryActivity::class.java)
            .putExtra("position", position)

        startActivity(intent)
//        val bundle = Bundle()
//
//        // Add data to the bundle
//        bundle.putString("name", "John")
//        var position = position
//        bundle.putInt("index", position)
//
//        // Set the bundle as the Fragment's arguments
//        arguments = bundle
//
//        intent.putExtra("storyIndex", position)

//        a=position
        Log.e("sher", "onCreate: Main fragment $position")


    }

}