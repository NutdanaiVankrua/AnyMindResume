package com.example.anymindresume.screen.resume.detail.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormSectionTitleBinding
import com.example.anymindresume.screen.resume.detail.ResumeForm

class ResumeFormSectionViewHolder(
    private val binding: ViewHolderFormSectionTitleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResumeForm.Section) {
        binding.textView.text = item.title
    }

}