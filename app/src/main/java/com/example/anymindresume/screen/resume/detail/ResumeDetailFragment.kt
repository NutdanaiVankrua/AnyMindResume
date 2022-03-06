package com.example.anymindresume.screen.resume.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.anymindresume.R
import com.example.anymindresume.databinding.FragmentResumeDetailBinding
import com.example.anymindresume.util.ActionBarDynamicTitle

class ResumeDetailFragment : Fragment(), ActionBarDynamicTitle {

    private var _binding: FragmentResumeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResumeDetailViewModel by viewModels()

    /**
     * TODO:
     *  1. design the view structure for resume detail to handling multiple inputs
     *  2. design which type of storage that we should use? (SharedPreference, Realm, Room, etc.?)
     *  3. handle lifecycle event when onPause should save to storage
     *  4. handle debounce when pause 500ms should save to storage
     *  5. handle when back press should ask to save or discard?
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResumeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().apply {
            setupTitle(title = resources.getString(R.string.navigation_bar_title_resume_detail_screen))
            showActionBar(visible = false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}