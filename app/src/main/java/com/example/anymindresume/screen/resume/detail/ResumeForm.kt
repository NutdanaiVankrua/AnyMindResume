package com.example.anymindresume.screen.resume.detail

import android.text.InputType

sealed class ResumeForm {

    data class Section(val title: String) : ResumeForm()
    data class Input(
        val input: String,
        val hint: String,
        val type: Type
    ) : ResumeForm() {

        enum class Type {
            MOBILE_NO,
            EMAIL;

            fun getInputMode(): Int {
                return when (this) {
                    MOBILE_NO -> InputType.TYPE_CLASS_PHONE
                    EMAIL -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                }
            }
        }

    }

}
