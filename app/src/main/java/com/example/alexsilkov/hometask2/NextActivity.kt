package com.example.alexsilkov.hometask2

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        var nameTextView: TextView = findViewById(R.id.name_view)
        var photoImageView: ImageView = findViewById(R.id.photo_view)
        var rop:Bundle

        nameTextView.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        rop = intent.getExtras()
        photoImageView.setImageBitmap(rop.get("data") as Bitmap)
    }
}
