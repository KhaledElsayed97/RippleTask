package com.example.ripplerepotask.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ripplerepotask.R
import com.example.ripplerepotask.databinding.FragmentRecyclerViewBinding
import com.example.ripplerepotask.databinding.FragmentRepoDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRepoDetailsBinding
    val args : RepoDetailsFragmentArgs by navArgs()

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

        binding.apply {
            tvRepoNameInput.text = args.repoName
            tvRepoDescInput.text = args.repoDesc
            Glide.with(view)
                .load(args.repoImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivRepoF)
        }
        }
    }
    
