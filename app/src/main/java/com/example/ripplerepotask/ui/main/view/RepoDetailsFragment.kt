package com.example.ripplerepotask.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ripplerepotask.R
import com.example.ripplerepotask.databinding.FragmentRecyclerViewBinding
import com.example.ripplerepotask.databinding.FragmentRepoDetailsBinding


class RepoDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRepoDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoDetailsBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("nameKey") { requestKey, bundle ->
            val repoName = bundle.getString("repoName")
            binding.tvRepoNameInput.text = repoName
        }
        setFragmentResultListener("descKey") { requestKey, bundle ->
            val repoDesc = bundle.getString("repoDesc")
            binding.tvRepoDescInput.text = repoDesc
        }
        setFragmentResultListener("imageKey") { requestKey, bundle ->
            val repoImage = bundle.getString("repoImage")
            Glide.with(this)
                .load(repoImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivRepoF)
        }
    }
    
}