package com.example.practice5activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_practice5_read_data.*
import kotlinx.android.synthetic.main.activity_practice5activity.*

class Practice5ReadDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5_read_data)

        val prodi = intent.getStringExtra(EXTRA_PRODI)
        lblProdiSaya.text = "Prodi Saya Adalah $prodi"


    }
    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }
}