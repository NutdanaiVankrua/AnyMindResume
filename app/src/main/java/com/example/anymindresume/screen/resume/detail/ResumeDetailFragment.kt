package com.example.anymindresume.screen.resume.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.anymindresume.databinding.FragmentResumeDetailBinding

class ResumeDetailFragment : Fragment() {

    private var _binding: FragmentResumeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResumeDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResumeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}