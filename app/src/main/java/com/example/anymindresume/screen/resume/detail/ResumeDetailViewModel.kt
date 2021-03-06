package com.example.anymindresume.screen.resume.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResumeDetailViewModel : ViewModel() {

    private var cacheForm: List<ResumeForm>? = null
    private val _form = MutableLiveData<List<ResumeForm>>()
    val form: LiveData<List<ResumeForm>> = _form

    fun getInitialForm() {
        _form.value = listOf(
            ResumeForm.Section(title = "Contact"),
            ResumeForm.Input(input = "", hint = "Mobile No.", type = ResumeForm.Input.Type.MobileNo),
            ResumeForm.Input(input = "", hint = "Email", type = ResumeForm.Input.Type.Email),
            ResumeForm.Section(title = "Experience"),
            ResumeForm.Input(input = "", hint = "Career Objective", type = ResumeForm.Input.Type.CareerObjective),
            ResumeForm.Input(
                input = "",
                hint = "Years of Experience",
                type = ResumeForm.Input.Type.YearsOfExperience
            ),
            ResumeForm.Generate.Type.WORK_SUMMARY.create(),
            ResumeForm.Generate.Type.EDUCATION.create(),
            ResumeForm.Generate.Type.PROJECT_DETAIL.create()
        )
    }

    fun addNewSection(section: ResumeForm.Generate.Type) {
        when (section) {
            ResumeForm.Generate.Type.WORK_SUMMARY -> addNewWorkSummarySection()
            ResumeForm.Generate.Type.EDUCATION -> addNewEducationSection()
            ResumeForm.Generate.Type.PROJECT_DETAIL -> addNewProjectDetailSection()
        }
    }

    private fun addNewWorkSummarySection() {
        consumeCacheForm()
        val currentForm = form.value?.toMutableList() ?: return
        val generateIndex = currentForm
            .indexOfFirst { it is ResumeForm.Generate && it.type == ResumeForm.Generate.Type.WORK_SUMMARY }
        if (generateIndex < 0)
            return
        val companySummaryCount = currentForm
            .count { it is ResumeForm.Input && it.type is ResumeForm.Input.Type.CompanyName }
        val inputCompany =
            ResumeForm.Input(
                input = "",
                hint = "Company Name",
                type = ResumeForm.Input.Type.CompanyName(index = companySummaryCount)
            )
        val inputStartDate = ResumeForm.DatePicker(
            hint = "Start",
            placeholderText = "mm/yyyy",
            type = ResumeForm.DatePicker.Type.CompanyStartDate(index = companySummaryCount)
        )
        val inputEndDate = ResumeForm.DatePicker(
            hint = "End",
            helperText = "*Leave empty if still in employment",
            placeholderText = "mm/yyyy",
            type = ResumeForm.DatePicker.Type.CompanyEndDate(index = companySummaryCount)
        )
        currentForm.addAll(generateIndex, listOf(inputCompany, inputStartDate, inputEndDate))
        _form.value = currentForm
    }

    private fun addNewEducationSection() {
        consumeCacheForm()
        val currentForm = form.value?.toMutableList() ?: return
        val generateIndex = currentForm
            .indexOfFirst { it is ResumeForm.Generate && it.type == ResumeForm.Generate.Type.EDUCATION }
        if (generateIndex < 0)
            return
        val educationCount = currentForm
            .count { it is ResumeForm.Input && it.type is ResumeForm.Input.Type.EducationClass }

        /**
         * TODO: Introduce drop down
         */
        val inputClass = ResumeForm.Input(
            input = "",
            hint = "Classes",
            type = ResumeForm.Input.Type.EducationClass(index = educationCount)
        )
        val inputPassingYear = ResumeForm.Input(
            input = "",
            hint = "Passing Year",
            type = ResumeForm.Input.Type.EducationPassingYear(index = educationCount)
        )
        val inputGPA = ResumeForm.Input(
            input = "",
            hint = "CGPA",
            type = ResumeForm.Input.Type.EducationGPA(index = educationCount)
        )
        currentForm.addAll(generateIndex, listOf(inputClass, inputPassingYear, inputGPA))
        _form.value = currentForm
    }

    private fun addNewProjectDetailSection() {
        consumeCacheForm()
        val currentForm = form.value?.toMutableList() ?: return
        val generateIndex = currentForm
            .indexOfFirst { it is ResumeForm.Generate && it.type == ResumeForm.Generate.Type.PROJECT_DETAIL }
        if (generateIndex < 0)
            return
        val projectDetailCount = currentForm
            .count { it is ResumeForm.Input && it.type is ResumeForm.Input.Type.ProjectDetailName }
        val inputProjectName = ResumeForm.Input(
            input = "",
            hint = "Project name",
            type = ResumeForm.Input.Type.ProjectDetailName(index = projectDetailCount)
        )
        val inputTeamSize = ResumeForm.Input(
            input = "",
            hint = "Team size",
            type = ResumeForm.Input.Type.ProjectDetailTeamSize(index = projectDetailCount)
        )
        val inputSummary = ResumeForm.Input(
            input = "",
            hint = "Summary",
            type = ResumeForm.Input.Type.ProjectDetailSummary(index = projectDetailCount)
        )
        val inputTechnology = ResumeForm.Input(
            input = "",
            hint = "Technology used",
            type = ResumeForm.Input.Type.ProjectDetailTechnology(index = projectDetailCount)
        )
        val inputRole = ResumeForm.Input(
            input = "",
            hint = "Role",
            type = ResumeForm.Input.Type.ProjectDetailRole(index = projectDetailCount)
        )
        currentForm.addAll(
            generateIndex,
            listOf(inputProjectName, inputTeamSize, inputSummary, inputTechnology, inputRole)
        )
        _form.value = currentForm
    }

    fun cacheInput(input: ResumeForm.Input) {
        consumeCacheForm()
        val currentForm = form.value?.toMutableList() ?: return
        val matchIndex = currentForm.indexOfFirst { it is ResumeForm.Input && it.type == input.type }
        if (matchIndex < 0)
            return
        currentForm[matchIndex] = input
        cacheForm = currentForm
    }

    private fun consumeCacheForm() {
        _form.value = cacheForm ?: return
        cacheForm = null
    }

}