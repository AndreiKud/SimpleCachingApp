package ru.andreikud.simplecachingapp.data.model.domain

import com.google.gson.annotations.SerializedName

class Day(
    val closesAt: String?,
    val isClosed: Boolean?,
    val opensAt: String?,
)