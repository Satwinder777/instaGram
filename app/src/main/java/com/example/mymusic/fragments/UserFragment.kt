package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mymusic.R
import com.example.mymusic.activity.EditProfileActivity
import com.example.mymusic.databinding.FragmentUserBinding
import com.example.taskviewpager.pageadapter.PageAdapter
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.ImagePicker.Companion.REQUEST_CODE
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso

class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding
    private lateinit var tabLayout : TabLayout
    private lateinit var editProfileCard : CardView
    private lateinit var shareProfileCard : CardView
    private lateinit var menuimguserFragment : ImageView
    private lateinit var username : TextView
    private lateinit var bio : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        viewPager.adapter = PageAdapter(requireContext(),childFragmentManager,lifecycle)
        viewPager.currentItem = 0
        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
        shareProfileCard = binding.shareProfileCard
        editProfileCard = binding.editProfileCArd
        menuimguserFragment = binding.menuimguserFragment
         username = binding.userNameofUserfrag
         bio = binding.bioofUserfrag

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.grid)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.reel_png)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.tag_png)

        //opertions

        shareProfileCard.setOnClickListener {  }
        editProfileCard.setOnClickListener {
            val intent  = Intent(requireContext(),EditProfileActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)

        }
        menuimguserFragment.setOnClickListener {
            var bp = BottomSheetDialog(requireContext())
           var view = layoutInflater.inflate(R.layout.user_menu_dialog,null)
            view.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_popup_bg))

            bp.setContentView(view)
            bp.show()
        }
        binding.CreateReelPost.setOnClickListener {
            var bp = BottomSheetDialog(requireContext())

            var view = layoutInflater.inflate(R.layout.usercreatepostreel,null)


            bp.setContentView(view)
            bp.show()
        }
        binding.pPhoto.setOnClickListener {
            ImagePicker.with(this).galleryOnly().start()
        }






    }
    var myobj = object :EditProfileActivity.dataIntent{
//            var rr = view!!.findViewById<TextView>(R.id.bioofUserfrag)
        @RequiresApi(Build.VERSION_CODES.P)
        override suspend fun IntentData(string: List<String>) {
            Log.e("test10", "IntentData: $string ")
            task10(string)
//            rr.setText(string.get(2))
            //      bug bug bug bug bug bug bug bug


        }

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.e("aaa", "onActivityResult:  $resultCode  ,$requestCode,${Activity.RESULT_OK},$data", )
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!
            Log.e("satwinder", ": $uri", )
            Picasso.get()
                .load(uri)
                .into(binding.pPhoto);
//            imgView.setImageURI(uri)


            ///////





//            Log.e("satwinder", "onActivityResult: $imageBitmap", )
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireContext(),ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
//
//        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            val receivedData = data?.getStringExtra("data_key")
//            // Do something with the received data here
//
//            val extras = data?.extras
//            val value = extras?.getString("data_key")
//            if (value == null) {
//                // Handle null value
//                Log.e("test10", "onActivityResult: nullllllll", )
//            }
//            else{
//                Log.e("test10", "onActivityResult: $receivedData", )
//
//            }
//        }


    }





    @RequiresApi(Build.VERSION_CODES.P)
    fun task10(list: List<String> ){
        list.forEachIndexed { index, s ->
//            username = binding.userNameofUserfrag
//            bio  = binding.bioofUserfrag
            when(index){
                0->{ Log.e("test10", "IntentData: $s", )}
                1->{}
                2->{}

//                1->{username.setText(s)}
//                2->{bio.setText(s)}
                else ->{
                    Log.e("test10", "IntentData: $s", )}
            }

        }

    }


}