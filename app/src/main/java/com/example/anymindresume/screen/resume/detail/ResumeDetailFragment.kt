package com.example.anymindresume.screen.resume.detail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anymindresume.R
import com.example.anymindresume.databinding.FragmentResumeDetailBinding
import com.example.anymindresume.util.ActionBarDynamicTitle

class ResumeDetailFragment : Fragment(), ActionBarDynamicTitle {

    private var _binding: FragmentResumeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ResumeDetailViewModel by viewModels()
    private val formAdapter = ResumeDetailRecyclerViewAdapter(
        onGenerateSectionAdd = {
            binding.recyclerView.clearFocus()
            viewModel.addNewSection(section = it)
        },
        onInputLoseFocus = { viewModel.cacheInput(input = it) }
    )

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
        setupViews()
        setupLiveDataObservers()
        viewModel.getInitialForm()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        requireActivity().apply {
            setupTitle(title = resources.getString(R.string.navigation_bar_title_resume_detail_screen))
            showActionBar(visible = false)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = formAdapter
        }
    }

    private fun setupLiveDataObservers() {
        viewModel.form.debounce(50).observe(viewLifecycleOwner) {
            formAdapter.submitList(it)
        }
    }

}

private fun <T> LiveData<T>.debounce(duration: Long = 1000L) = MediatorLiveData<T>().also { mld ->
    val source = this
    val handler = Handler(Looper.getMainLooper())

    val runnable = Runnable {
        mld.value = source.value
    }

    mld.addSource(source) {
        handler.removeCallbacks(runnable)
        handler.postDelayed(runnable, duration)
    }
}
