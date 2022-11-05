package com.marcsogasdev.exemplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.marcsogasdev.exemplemvvm.databinding.ActivityMainBinding
import com.marcsogasdev.exemplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //logic and connection viewModel to activity (lifecycle...)
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    //connect view model to activity
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author

        })
        //click for the screen
        binding.viewContainer.setOnClickListener{ quoteViewModel.randomQuote()}
    }
}