package com.example.anymindresume.screen.resume.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.anymindresume.databinding.ViewHolderFormInputBinding
import com.example.anymindresume.databinding.ViewHolderFormSectionTitleBinding
import com.example.anymindresume.screen.resume.detail.view.holders.ResumeFormInputViewHolder
import com.example.anymindresume.screen.resume.detail.view.holders.ResumeFormSectionViewHolder

class ResumeDetailRecyclerViewAdapter : ListAdapter<ResumeForm, RecyclerView.ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<ResumeForm>() {
        override fun areItemsTheSame(oldItem: ResumeForm, newItem: ResumeForm): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResumeForm, newItem: ResumeForm): Boolean {
            return oldItem == newItem
        }
    }

    enum class ViewHolderType(val rawValue: Int) {
        SECTION(0),
        INPUT(1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewHolderType.SECTION.rawValue -> {
                val binding = ViewHolderFormSectionTitleBinding.inflate(inflater, parent, false)
                ResumeFormSectionViewHolder(binding)
            }
            ViewHolderType.INPUT.rawValue -> {
                val binding = ViewHolderFormInputBinding.inflate(inflater, parent, false)
                ResumeFormInputViewHolder(binding)
            }
            else -> TODO("not yet implemented")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ResumeFormSectionViewHolder -> {
                val item = getItem(position) as? ResumeForm.Section ?: return
                holder.bind(item = item)
            }
            is ResumeFormInputViewHolder -> {
                val item = getItem(position) as? ResumeForm.Input ?: return
                holder.bind(item = item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ResumeForm.Input -> ViewHolderType.INPUT.rawValue
            is ResumeForm.Section -> ViewHolderType.SECTION.rawValue
        }
    }

}