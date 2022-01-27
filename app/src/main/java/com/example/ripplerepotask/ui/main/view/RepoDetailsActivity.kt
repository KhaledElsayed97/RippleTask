package com.example.ripplerepotask.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ripplerepotask.databinding.ActivityRepoDetailsBinding

class RepoDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repoName : String? = intent.getStringExtra("name")
        var repoDesc : String? = intent.getStringExtra("desc")
        var avatarURL : String? = intent.getStringExtra("avatar_url")



        binding.apply {
            Glide.with(applicationContext)
                .load(avatarURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivRepoF)

            tvRepoNameInput.text = repoName
            tvRepoDescInput.text = repoDesc

            btnBack.setOnClickListener {
                val intent = Intent(this@RepoDetailsActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }




    }
}