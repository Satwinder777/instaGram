package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.example.mymusic.R
import com.example.mymusic.activity.ChatActivity
import com.example.mymusic.adapter.MassageAdapter
import com.example.mymusic.dataClass.Unsplaceapi
import com.example.mymusic.databinding.FragmentMassageBinding
import com.example.mymusic.`interface`.uspInterface
import com.example.mymusicobject.Helper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MassageFragment : Fragment(),MassageAdapter.OnItemClick {
    private lateinit var binding:FragmentMassageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMassageBinding.inflate(inflater,container,false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_massage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView:RecyclerView = binding.recyclerMassages
        var list = mutableListOf<Unsplaceapi>()
        list = mutableListOf()
        val adapter = MassageAdapter(requireContext(),list,this)
        recyclerView.adapter = adapter

        var request = Helper.getResp()
        var interface1 = request.create(uspInterface::class.java)
        interface1.getImage()
        var call: Call<Unsplaceapi> = interface1.getImage()
//        val call: Call<QuoteList> = quotesApi.getQuote()

      call.enqueue(object:Callback<Unsplaceapi>{
          @SuppressLint("NotifyDataSetChanged")
          override fun onResponse(call: Call<Unsplaceapi>, response: Response<Unsplaceapi>) {
              if (response.isSuccessful){
                  var myData = response.body()!!
                  for (data in 0..myData.size-1){
                      list.add(myData)
                      recyclerView.adapter = adapter
                      adapter.notifyDataSetChanged()
                  }

              }
              else {
                  Toast.makeText(requireContext(), "error to get responce", Toast.LENGTH_SHORT).show()

              }
          }

          override fun onFailure(call: Call<Unsplaceapi>, t: Throwable) {
              Toast.makeText(requireContext(), "got error", Toast.LENGTH_SHORT).show()
          }

      })
        binding.massageBack.setOnClickListener {

        }
        setControl(view)


    }

    override fun onClickItem(position: Int) {
        val intent = Intent(requireContext(),ChatActivity::class.java)
        startActivity(intent)
        Toast.makeText(requireContext(), "$position", Toast.LENGTH_SHORT).show()
    }

    private fun setControl(view: View){
        binding.massageBack
        .setOnClickListener {
            var viewPager=view.parent as ViewPager
            viewPager.setCurrentItem(1,true)
        }
    }
}