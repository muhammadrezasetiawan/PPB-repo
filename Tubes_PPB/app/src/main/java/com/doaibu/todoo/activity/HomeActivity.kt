package com.doaibu.todoo.activity

import android.os.Bundle
import android.widget.TextView
import com.doaibu.todoo.R
import com.doaibu.todoo.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}