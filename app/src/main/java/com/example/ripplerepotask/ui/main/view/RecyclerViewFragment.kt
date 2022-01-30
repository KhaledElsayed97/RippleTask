package com.example.ripplerepotask.ui.main.view

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripplerepotask.R
import com.example.ripplerepotask.databinding.ActivityMainBinding
import com.example.ripplerepotask.databinding.FragmentRecyclerViewBinding
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import com.example.ripplerepotask.ui.main.viewmodel.MainViewModel
import org.koin.android.ext.android.inject


class RecyclerViewFragment : Fragment() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var binding : FragmentRecyclerViewBinding
    private val  adapter : MainAdapter by inject()
    private val viewModel : MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setupUI()

        setupObserver()
    }

    private fun setupUI(){
        adapter.notifyDataSetChanged()

        binding.apply {
            rvRepo.layoutManager = LinearLayoutManager(context)
            rvRepo.setHasFixedSize(true)
            rvRepo.adapter = adapter

            adapter.onItemClick = { repository ->

                setFragmentResult("nameKey", bundleOf("repoName" to repository.name))
                setFragmentResult("descKey", bundleOf("repoDesc" to repository.description))
                setFragmentResult("imageKey", bundleOf("repoImage" to repository.owner.avatar_url))

                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(activityMainBinding.flFragment.id, RepoDetailsFragment())
                transaction?.addToBackStack(null)
                transaction?.commit()
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

    private fun setupObserver(){
        viewModel.getSearchRepos().observe(viewLifecycleOwner,{
            if (it!=null){
                adapter.setRepoList(it)
                showLoading(false)
            }
        })
    }
}