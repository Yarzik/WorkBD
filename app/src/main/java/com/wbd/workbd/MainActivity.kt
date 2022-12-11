package com.wbd.workbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.wbd.workbd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingBtn.setOnClickListener{
            val navHost = Navigation.findNavController(this, R.id.fragmentContainerView)
            navHost.navigate(R.id.action_showFragment_to_editFragment)
        }
    }
}