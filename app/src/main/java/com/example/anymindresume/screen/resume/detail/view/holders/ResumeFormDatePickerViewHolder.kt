package com.example.anymindresume.screen.resume.detail.view.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormDatePickerBinding
import com.example.anymindresume.screen.resume.detail.ResumeForm

class ResumeFormDatePickerViewHolder(
    private val binding: ViewHolderFormDatePickerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResumeForm.DatePicker) {
        binding.textInputLayout.apply {
            hint = item.hint
            placeholderText = item.placeholderText
            helperText = item.helperText
        }
    }

}