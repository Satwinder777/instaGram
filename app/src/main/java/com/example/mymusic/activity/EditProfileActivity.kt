package com.example.mymusic.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.os.bundleOf
import com.example.mymusic.databinding.ActivityEditProfileBinding
import com.example.mymusic.fragments.UserFragment
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
      var data : List<String>? =null
//    val myList: List<String>? = null
    private lateinit var name1:EditText
    private lateinit var username1:EditText
    private lateinit var bio1:EditText
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name1 = binding.editName
        username1 = binding.editUsername
        bio1 = binding.editBio

        var name = name1.text
        val username = username1.text
        val bio = bio1.text


//            name ="satta"
//        val resultIntent = Intent()
//        resultIntent.putExtra("data_key", data)
//        setResult(Activity.RESULT_OK, resultIntent)
//        intent.putExtra("data_key", data)




        binding.submitData.setOnClickListener {
            data = listOf("$name","$username","$bio")
            val myVar: EditProfileActivity.dataIntent = UserFragment().myobj
            GlobalScope.launch {
                myVar.IntentData(data!!)
            }
            finish()
            Log.e("test10", "onCreate: data :- $data", )
        }
    }


   interface dataIntent{
        suspend fun IntentData(string: List<String>)

    }
}