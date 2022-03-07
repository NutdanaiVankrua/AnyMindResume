package com.example.anymindresume.screen.resume.detail

import android.text.InputType

sealed class ResumeForm {

    data class Section(val title: String) : ResumeForm()

    data class Input(
        val input: String,
        val hint: String,
        val type: Type
    ) : ResumeForm() {

        sealed class Type {
            object MobileNo : Type()
            object Email : Type()
            object CareerObjective : Type()
            object YearsOfExperience : Type()
            data class CompanyName(val index: Int) : Type()
            data class EducationClass(val index: Int) : Type()
            data class EducationPassingYear(val index: Int) : Type()
            data class EducationGPA(val index: Int) : Type()
            data class ProjectDetailName(val index: Int) : Type()
            data class ProjectDetailTeamSize(val index: Int) : Type()
            data class ProjectDetailSummary(val index: Int) : Type()
            data class ProjectDetailTechnology(val index: Int) : Type()
            data class ProjectDetailRole(val index: Int) : Type()

            fun getInputMode(): Int {
                return when (this) {
                    MobileNo -> InputType.TYPE_CLASS_PHONE
                    Email -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    CareerObjective -> InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
                    YearsOfExperience -> InputType.TYPE_CLASS_NUMBER
                    else -> InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
                }
            }

        }

    }

    data class DatePicker(
        val hint: String,
        val helperText: String? = null,
        val placeholderText: String,
        val type: Type
    ) : ResumeForm() {

        sealed class Type {
            data class CompanyStartDate(val index: Int) : Type()
            data class CompanyEndDate(val index: Int) : Type()
        }

    }

    data class Generate(
        val title: String,
        val type: Type
    ) : ResumeForm() {

        enum class Type {
            WORK_SUMMARY,
            EDUCATION,
            PROJECT_DETAIL;

            fun create(): Generate {
                return when (this) {
                    WORK_SUMMARY -> Generate(
                        title = "Work Summary",
                        type = WORK_SUMMARY
                    )
                    EDUCATION -> Generate(
                        title = "Education",
                        type = EDUCATION
                    )
                    PROJECT_DETAIL -> Generate(
                        title = "Project Details",
                        type = PROJECT_DETAIL
                    )
                }
            }
        }

    }

}
