package com.example.anymindresume.screen.myresumes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.anymindresume.R
import com.example.anymindresume.databinding.FragmentMyResumesBinding
import com.example.anymindresume.util.ActionBarDynamicTitle

class MyResumesFragment : Fragment(), ActionBarDynamicTitle {

    private var _binding: FragmentMyResumesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyResumesViewModel by viewModels()
    private val adapter = MyResumesRecyclerViewAdapter(onItemClick = {
        findNavController().navigate(R.id.action_my_resumes_to_resume_detail)
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMyResumesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupLiveDataObservers()
        viewModel.getResumes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupLiveDataObservers() {
        viewModel.resumes.observe(viewLifecycleOwner) {
            adapter.apply {
                items.addAll(it)
                notifyItemRangeChanged(0, items.count())
            }
        }
    }

    private fun setupViews() {
        requireActivity().setupTitle(title = resources.getString(R.string.navigation_bar_title_my_resumes_screen))
        binding.recyclerView.adapter = adapter
        binding.floatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_my_resumes_to_resume_detail)
        }
    }

}