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
            data class StartDate(val index: Int) : Type()
            data class EndDate(val index: Int) : Type()

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

    data class Generate(
        val title: String,
        val type: Type
    ) : ResumeForm() {

        enum class Type {
            WORK_SUMMARY,
            EDUCATION
        }

    }

}
