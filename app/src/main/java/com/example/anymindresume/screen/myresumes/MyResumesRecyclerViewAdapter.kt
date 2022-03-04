package com.example.anymindresume.screen.myresumes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderMyResumeBinding

class MyResumesRecyclerViewAdapter(
    var items: MutableList<Resume> = mutableListOf()
) : RecyclerView.Adapter<MyResumesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewHolderMyResumeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderMyResumeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO
    }

    override fun getItemCount(): Int = 17

}