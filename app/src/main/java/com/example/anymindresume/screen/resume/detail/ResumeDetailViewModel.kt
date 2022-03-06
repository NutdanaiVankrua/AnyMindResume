package com.example.anymindresume.screen.resume.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResumeDetailViewModel : ViewModel() {

    private val _form = MutableLiveData<List<ResumeForm>>()
    val form: LiveData<List<ResumeForm>> = _form

    fun getInitialForm() {
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

    fun addNewWorkSummarySection(section: ResumeForm.Generate.Type) {
        val currentForm = form.value?.toMutableList() ?: return
        val generateIndex = currentForm.indexOfFirst { it is ResumeForm.Generate && it.type == section }
        if (generateIndex < 0)
            return

        val inputCompany =
            ResumeForm.Input(input = "", hint = "Company Name.", type = ResumeForm.Input.Type.COMPANY_NAME)

        /**
         * TODO: use date picker instead, need to introduce new type of view holder
         */
        val inputStartDate = ResumeForm.Input(input = "", hint = "Start", type = ResumeForm.Input.Type.START_DATE)
        val inputEndDate = ResumeForm.Input(input = "", hint = "End", type = ResumeForm.Input.Type.END_DATE)

        currentForm.addAll(generateIndex, listOf(inputCompany, inputStartDate, inputEndDate))
        _form.value = currentForm
    }

}