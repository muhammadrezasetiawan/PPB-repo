package com.rezasetiawan_18102205.lifecycleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPage.setOnClickListener{
            val intent = Intent(this, HalamanDuaActivity::class.java)
            startActivity(intent)
        }
    }


    fun printState(msg: String){
        Log.d("ActivityState",msg)
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        printState("Halaman Satu On Start")
    }

    override fun onResume() {
        super.onResume()
        printState("Halaman Satu On Resume")
    }

    override fun onPause() {
        super.onPause()
        printState("Halaman Satu On Pause")
    }

    override fun onStop() {
        super.onStop()
        printState("Halaman Satu On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printState("Halaman Satu On Destroy")
    }
}



