package com.example.mymusic.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.hardware.Camera
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.Surface.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.mymusic.activity.GalleryActivity
import com.example.mymusic.databinding.FragmentCamera2Binding
import com.google.android.material.snackbar.Snackbar
import com.google.common.util.concurrent.ListenableFuture
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.app.Activity
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.view.PreviewView
import com.example.mymusic.R
import com.github.dhaval2404.imagepicker.ImagePicker
import com.shz.imagepicker.imagepicker.ImagePickerCallback
import com.shz.imagepicker.imagepicker.model.PickedResult
import com.squareup.picasso.Picasso


  class CameraFragment : Fragment(), ImagePickerCallback {
    private lateinit var binding: FragmentCamera2Binding
    private lateinit var cameraSelector: CameraSelector
    private lateinit var imgView: ImageView
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private var camera: Camera? = null
    private lateinit var btn :ImageView
    private lateinit var file: File
    private lateinit var PreviewView: PreviewView
//    private lateinit var surfaceHolder: SurfaceHolder
    val CAMERA_REQUEST_CODE = 1888
    private var imageCapture: ImageCapture? = null
    private lateinit var imgCaptureExecutor: ExecutorService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCamera2Binding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
          val cameraProviderResult = registerForActivityResult(ActivityResultContracts.RequestPermission()){ permissionGranted->
            if(permissionGranted){
                // cut and paste the previous startCamera() call here.
                startCamera()
            }else {
                Snackbar.make(binding.root,"The camera permission is required", Snackbar.LENGTH_INDEFINITE).show()
            }
              imgCaptureExecutor = Executors.newSingleThreadExecutor()
        }


        startCamera()
        cameraProviderResult.launch(android.Manifest.permission.CAMERA)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        surfaceHolder = binding.cameraPreview.holder
//        surfaceHolder = view.camera_preview.holder
//        val surfaceView = view.findViewById<SurfaceView>(R.id.camera_preview)

        binding.imgCaptureBtn.setOnClickListener{
//            takePhoto()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                animateFlash()
            }

        }
        binding.galleryBtn.setOnClickListener {
//            val intent = Intent(requireContext(), GalleryActivity::class.java)
//            startActivity(intent)
//            openGallery()
            var imgdata =  ImagePicker.with(this).galleryOnly().start()
//            var imgdata1 = com.github.dhaval2404.imagepicker.ImagePicker.with(this).r
            Log.e("asas", "onViewCreated: $imgdata.", )
        }
        binding.switchBtn.setOnClickListener {
            //change the cameraSelector
//            cameraSelector = if(cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA){
//                CameraSelector.DEFAULT_FRONT_CAMERA
//            }else {
//                CameraSelector.DEFAULT_BACK_CAMERA
//            }
            // restart the camera
//            startCamera()
            var imgdata = ImagePicker.with(this).cameraOnly().start()
        }



        btn = view.findViewById(R.id.imgCaptureBtn)

        btn.setOnClickListener {
//           var imh= ImagePicker.with(this).cameraOnly().start()
//            Log.e("imh", "onViewCreated: $imh", )
            var imgdata = com.github.dhaval2404.imagepicker.ImagePicker.with(this).cameraOnly().start()
            btnclick()
            takePhoto()
        }

        imgView = binding.imgv1
        PreviewView = binding.preview

        val fileName = "JPEG_${System.currentTimeMillis()}"
        var data = requireActivity().externalCacheDirs[0]
        file = File(  data ,fileName )
        val imageBitmap = BitmapFactory.decodeFile(file.absolutePath)
        imgView.setImageBitmap(imageBitmap)

    }


//        imgView = findViewById(R.id.imageView)


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(requireContext(), "Access user", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(requireContext(), "permission Denied", Toast.LENGTH_SHORT).show()

        }


    }

    private fun startCamera(){
        // listening for data from the camera
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
//            imageCapture = ImageCapture.Builder().build()

            // connecting a preview use case to the preview in the xml file.
            val preview = Preview.Builder().build().also{
                it.setSurfaceProvider(binding.preview.surfaceProvider)
            }
            try{
                // clear all the previous use cases first.
                cameraProvider.unbindAll()
                // binding the lifecycle of the camera to the lifecycle of the application.
                cameraProvider.bindToLifecycle(this,cameraSelector,preview)
            } catch (e: Exception) {
                Log.d("cam", "Use case binding failed")
            }

        }, ContextCompat.getMainExecutor(requireContext()))


}

    @SuppressLint("SuspiciousIndentation")
    private fun takePhoto(){
        imageCapture?.let{

            val outputFileOptions = ImageCapture.OutputFileOptions.Builder(file).build()
//            try{
                it.takePicture(outputFileOptions, imgCaptureExecutor, object : ImageCapture.OnImageSavedCallback {


                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults){
                        Log.e("data","The image has been saved in ${file.toUri()}")

                        val savedUri = outputFileResults.savedUri ?: Uri.fromFile(File(outputFileResults.savedUri.toString()))
                        // Display the saved image in an ImageView.
                        Log.e("data", "onImageSaved:  ${savedUri.path.toString()}", )
//                        imageView.setImageURI(savedUri)
                        println("    lshiusddvhiushvksahvskjvhsaihvshskvhsiahaivssviuqwh9qu0ow${savedUri.path.toString()}")
                    }

                    override fun onError(exception: ImageCaptureException) {
                        Toast.makeText(
                            binding.root.context,
                            "Error taking photo",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.d("data", "Error taking photo:${exception.message}")
                    }


                })

//            }
//            catch (e:Exception){
//                Log.e("abc", "takePhoto: ${e.message}", )
//            }
        }

    }
    private fun animateFlash() {
        binding.root.postDelayed({
            binding.root.foreground = ColorDrawable(Color.WHITE)
            binding.root.postDelayed({
                binding.root.foreground = null
            }, 50)
        }, 100)
    }

    override fun onImagePickerResult(result: PickedResult) {
        when (result) {
            PickedResult.Empty -> {
                // No file was selected, noting to do
                Log.e("asas", "PickedResult.Empty: $file", )

            }
            is PickedResult.Error -> {
                val throwable = result.throwable
                // Some error happened, handle this throwable
            }
            is PickedResult.Multiple -> {
                val pickedImages = result.images
                val files = pickedImages.map { it.file }
                // Selected multiple images, do whatever you want with files
                Log.e("asas", "PickedResult.Multiple: $file", )

            }
            is PickedResult.Single -> {
                val pickedImage = result.image
                val file = pickedImage.file
                Log.e("asas", "pickedImage.file: $file", )
                // Selected one image, do whatever you want with file
            }
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
                .into(imgView);
//            imgView.setImageURI(uri)




//            Log.e("satwinder", "onActivityResult: $imageBitmap", )
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireContext(),ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    private fun btnclick(){
        if (PreviewView.visibility ==View.VISIBLE){
            PreviewView.visibility =View.GONE
            imgView.visibility = View.VISIBLE
            Log.e("satta", "btnclick: btn clicked", )
        }
    }
      val REQUEST_CODE = 200

      private fun openGallery() {
          val intent = Intent(Intent.ACTION_PICK)
          intent.type = "image/*"
          startActivityForResult(intent, REQUEST_CODE)
      }



}