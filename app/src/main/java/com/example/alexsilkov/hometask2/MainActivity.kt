package com.example.alexsilkov.hometask2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.net.URI

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mphButt: Button = findViewById(R.id.mPh_but)
        var namenter: EditText = findViewById(R.id.name_entering)

        mphButt.setOnClickListener(View.OnClickListener {
            var name = namenter.text.toString()
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(Intent.EXTRA_TEXT, name)
            if (name_entering.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "Please, enter your name", Toast.LENGTH_SHORT).show()
            } else {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val name = intent.getStringExtra(Intent.EXTRA_TEXT)
        var extras:Bundle
        var thePick:Bitmap
        var intent = Intent(applicationContext,NextActivity::class.java)
        intent.putExtra(Intent.EXTRA_TEXT,name)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
           extras = data!!.getExtras()
            thePick = data.getExtras().get("data") as Bitmap
            intent.putExtra(Intent.EXTRA_STREAM,thePick)
            startActivity(intent)
        }
    }
}
