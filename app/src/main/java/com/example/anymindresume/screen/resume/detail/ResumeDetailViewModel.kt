package com.example.anymindresume.screen.resume.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResumeDetailViewModel : ViewModel() {

    private val _form = MutableLiveData<List<ResumeForm>>()
    val form: LiveData<List<ResumeForm>> = _form

    fun getForm() {
        _form.value = listOf(
            ResumeForm.Section(title = "Contact"),
            ResumeForm.Input(input = "", hint = "Mobile No.", type = ResumeForm.Input.Type.MOBILE_NO),
            ResumeForm.Input(input = "", hint = "Email", type = ResumeForm.Input.Type.EMAIL),
            ResumeForm.Section(title = "Experience"),
            ResumeForm.Input(input = "", hint = "Career Objective", type = ResumeForm.Input.Type.CAREER_OBJECTIVE),
            ResumeForm.Input(
                input = "",
                hint = "Years of Experience",
                type = ResumeForm.Input.Type.YEARS_OF_EXPERIENCE
            ),
            ResumeForm.Generate(
                title = "Work Summary",
                type = ResumeForm.Generate.Type.WORK_SUMMARY
            ),
            ResumeForm.Generate(
                title = "Education",
                type = ResumeForm.Generate.Type.EDUCATION
            )
        )
    }

}