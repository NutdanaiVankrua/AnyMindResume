package com.example.anymindresume.screen.myresumes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyResumesViewModel : ViewModel() {

    private val _resumes = MutableLiveData<List<Resume>>()
    val resumes: LiveData<List<Resume>> = _resumes

    /**
     * TODO: retrieve from local storage (shared preference, realm, etc.?)
     */
    fun getResumes() {
        val mock = Resume(
            name = "Example",
            contact = Contact(
                address = "",
                mobile = "",
                email = ""
            ),
            experience = Experience(
                careerObjective = "",
                yearsOfExperience = 2,
                history = emptyList()
            ),
            educations = emptyList(),
            projects = emptyList()
        )
        _resumes.value = listOf(mock, mock, mock, mock)
    }

}