package com.example.myappsem6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class Jan31ImagePicker : AppCompatActivity() {
    lateinit var uploadImage: Button
    lateinit var iv: ImageView
    lateinit var filepath: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jan31_image_picker)
        uploadImage = findViewById(R.id.btn_upload_image)

        iv = findViewById(R.id.image_preview)

        val ip = registerForActivityResult(ActivityResultContracts.GetContent())
        {
            filepath = it!!
            iv.setImageURI(it)
        }
        uploadImage.setOnClickListener() {
            ip.launch("image/*")

        }
    }
}