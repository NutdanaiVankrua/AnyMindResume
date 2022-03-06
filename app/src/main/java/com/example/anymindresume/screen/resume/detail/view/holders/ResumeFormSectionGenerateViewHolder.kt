package com.example.anymindresume.screen.resume.detail.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormGenerateBinding
import com.example.anymindresume.screen.resume.detail.ResumeForm

class ResumeFormSectionGenerateViewHolder(
    private val binding: ViewHolderFormGenerateBinding,
    private val onAdd: (ResumeForm.Generate.Type) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResumeForm.Generate) {
        binding.textView.text = item.title
        binding.buttonAdd.setOnClickListener {
            onAdd(item.type)
        }
    }

}