package com.example.anymindresume.screen.resume.detail.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormInputBinding
import com.example.anymindresume.screen.resume.detail.ResumeForm

class ResumeFormInputViewHolder(
    private val binding: ViewHolderFormInputBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResumeForm.Input) {
        binding.textInputLayout.hint = item.hint
        binding.editTextMobileNo.inputType = item.type.getInputMode()
    }

}