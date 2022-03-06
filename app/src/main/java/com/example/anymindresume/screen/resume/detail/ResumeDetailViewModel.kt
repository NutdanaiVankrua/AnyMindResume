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
            ResumeForm.Input(input = "", hint = "Email", type = ResumeForm.Input.Type.EMAIL)
        )
    }

}