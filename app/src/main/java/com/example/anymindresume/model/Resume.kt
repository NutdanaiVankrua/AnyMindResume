package com.example.anymindresume.model

import java.util.*

data class Resume(
    val name: String,
    val contact: Contact,
    val experience: Experience,
    val educations: List<Education>,
    val projects: List<Project>
)

data class Contact(
    val address: String,
    val mobile: String,
    val email: String
)

data class Experience(
    val careerObjective: String,
    val yearsOfExperience: Int,
    val history: List<Organization>
) {

    data class Organization(
        val name: String,
        val start: Date,
        val end: Date,
        val description: String?
    )

}

data class Education(
    val classes: Class,
    val passingYear: Int,
    val cgpa: Float // max 2 floating points
) {

    enum class Class {
        X, XII, GRADUATION
    }

}

data class Project(
    val name: String,
    val teamSize: Int,
    val summary: String,
    val techStack: String,
    val role: String
)