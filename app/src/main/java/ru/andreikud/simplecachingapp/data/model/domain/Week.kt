package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import ru.andreikud.simplecachingapp.data.model.domain.Day

@Entity(tableName = "week")
data class Week(
    val monday: Day?,
    val tuesday: Day?,
    val wednesday: Day?,
    val thursday: Day?,
    val friday: Day?,
    val saturday: Day?,
    val sunday: Day?,
)