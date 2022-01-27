package com.example.ripplerepotask.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripplerepotask.databinding.ActivityMainBinding
import com.example.ripplerepotask.databinding.ActivityRepoDetailsBinding
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import com.example.ripplerepotask.ui.main.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity: AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var bindingRepoDetails : ActivityRepoDetailsBinding
    private val  adapter : MainAdapter by inject()
    private val viewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

        setupObserver()

    }

    private fun setupUI(){

        //adapter = MainAdapter()
        adapter.notifyDataSetChanged()
        //viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.apply {
            rvRepo.layoutManager = LinearLayoutManager(this@MainActivity)
            rvRepo.setHasFixedSize(true)
            rvRepo.adapter = adapter

            adapter.onItemClick= { repository ->

                val intent = Intent(this@MainActivity, RepoDetailsActivity::class.java)
                intent.putExtra("name",repository.name)
                intent.putExtra("desc",repository.description)
                intent.putExtra("avatar_url",repository.owner.avatar_url)
                startActivity(intent)

                //Log.d("TAG",repository.name)
            }

            btnSearch.setOnClickListener{
                searchRepo()
            }

            etQuery.setOnKeyListener { v, keyCode, event ->
                if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    searchRepo()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }

    }

    private fun setupObserver(){
        viewModel.getSearchRepos().observe(this,{
            if (it!=null){
                adapter.setRepoList(it)
                showLoading(false)
            }
        })
    }

    private fun searchRepo(){
        binding.apply {
            val query = etQuery.text.toString()
            if(query.isEmpty()) return
            showLoading(true)
            viewModel.setSearchRepos(query)
        }
    }

    private fun showLoading(state: Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}