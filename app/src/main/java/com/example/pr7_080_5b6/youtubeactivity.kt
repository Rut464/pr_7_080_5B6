package com.example.pr7_080_5b6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import androidx.core.view.WindowCompat
import com.example.pr7_080_5b6.databinding.ActivityYoutubeactivityBinding

class youtubeactivity : AppCompatActivity() {
    private lateinit var binding: ActivityYoutubeactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityYoutubeactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initYoutubePlayer()
        binding.btnSwitch.setOnClickListener {
        Intent(this,MainActivity::class.java).also { startActivity(it) }
        }
    }
    private val youtubeid = "ohF93_k3IMk"
    private fun initYoutubePlayer() {
        val webSettings: WebSettings = binding.youtubeWebview.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort=true
        binding.youtubeWebview.loadUrl("https://www.youtube.com/embed/$youtubeid")
    }
}