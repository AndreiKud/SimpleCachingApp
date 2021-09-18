package ru.andreikud.simplecachingapp.data.model.domain

import com.google.gson.annotations.SerializedName

data class Restaurant(
    val address: String?,
    val description: String?,
    val hours: List<Day>?,
    val id: Int?,
    val logo: String?,
    val name: String?,
    val phoneNumber: String?,
    val review: String?,
    val type: String?,
    val uid: String?,
)