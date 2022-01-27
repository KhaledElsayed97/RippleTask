package com.example.ripplerepotask.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.ripplerepotask.data.model.Repository
import com.example.ripplerepotask.databinding.ItemRepoBinding

class MainAdapter(private val list: ArrayList<Repository>) : RecyclerView.Adapter<MainAdapter.RepoViewHolder>() {

    var onItemClick : ((Repository) -> Unit)? = null

    fun setRepoList(repos: ArrayList<Repository>){
        list.clear()
        list.addAll(repos)
        notifyDataSetChanged()
    }
    inner class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(repo: Repository){
            binding.apply {
                Glide.with(itemView)
                    .load(repo.owner.avatar_url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivRepo)

                tvRepo.text = repo.name
                tvDescRepo.text = repo.description
            }

            binding.root.setOnClickListener {
                onItemClick?.invoke(repo)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = ItemRepoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepoViewHolder((view))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}