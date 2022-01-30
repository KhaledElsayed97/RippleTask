package com.example.ripplerepotask.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripplerepotask.databinding.ActivityMainBinding
import com.example.ripplerepotask.databinding.FragmentRecyclerViewBinding
import com.example.ripplerepotask.databinding.FragmentRepoDetailsBinding
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import com.example.ripplerepotask.ui.main.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity: AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.flFragment.id, RecyclerViewFragment())
        transaction.addToBackStack(null)
        transaction.commit()

    }


}