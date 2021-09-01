package com.kevcar.uitestdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kevcar.uitestdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: CounterViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        viewModel.stateData.observe(this) {
            binding.counterText.text = it.count.toString()
        }
        binding.add.setOnClickListener {
            viewModel.add()
        }

        binding.subtract.setOnClickListener {
            viewModel.subtract()
        }
    }
}
