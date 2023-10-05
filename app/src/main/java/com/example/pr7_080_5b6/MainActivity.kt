package com.example.pr7_080_5b6

import android.content.Intent
import android.media.MediaController2
import android.media.session.MediaController
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.pr7_080_5b6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnNext.setOnClickListener {
            Intent(this, youtubeactivity::class.java).also { startActivity(it) }
        }
    }

    private fun initVideoPlayer() {
        val mediaController = android.widget.MediaController(this)
        val uri: Uri = Uri.parse("android.resource://" + packageName+"/"+R.raw.thestoryoflight)
        binding.video.setMediaController(mediaController)
        mediaController.setAnchorView(binding.video)
        binding.video.setVideoURI(uri)
        binding.video.requestFocus()
        binding.video.start()
    }
}