package com.example.anymindresume.screen.resume.detail.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormInputBinding
import com.example.anymindresume.screen.resume.detail.ResumeForm

class ResumeFormInputViewHolder(
    private val binding: ViewHolderFormInputBinding,
    private val onInputLoseFocus: (ResumeForm.Input) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResumeForm.Input) {
        setupOnFocusChangeListener(item = item)
        binding.textInputLayout.hint = item.hint
        binding.editText.apply {
            setText(item.input)
            inputType = item.type.getInputMode()
        }
    }

    private fun setupOnFocusChangeListener(item: ResumeForm.Input) {
        binding.editText.setOnFocusChangeListener { _, isFocus ->
            if (isFocus) {
                return@setOnFocusChangeListener
            } else {
                val updateItem = item.copy(input = binding.editText.text.toString())
                onInputLoseFocus(updateItem)
            }
        }
    }

}