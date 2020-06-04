package dev.rstockbridge.greetingmvvm.view

import dev.rstockbridge.greetingmvvm.viewmodel.GreetingViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.rstockbridge.greetingmvvm.databinding.ActivityMainBinding

// This activity *is* rotation safe
class GreetingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: GreetingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { viewModel.onButtonClicked() }

        viewModel = ViewModelProvider(this).get(GreetingViewModel::class.java)
        viewModel.message.observe(this, Observer { message -> showMessage(message) })
    }

    private fun showMessage(text: String) {
        binding.label.text = text
    }
}
