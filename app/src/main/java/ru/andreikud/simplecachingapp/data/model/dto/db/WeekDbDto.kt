package ru.andreikud.simplecachingapp.data.model.dto.db

import androidx.room.Entity
import ru.andreikud.simplecachingapp.data.model.domain.Week
import ru.andreikud.simplecachingapp.data.model.dto.network.WeekNetDto

@Entity(tableName = "week")
class WeekDbDto(
    val monday: DayDbDto? = null,
    val tuesday: DayDbDto? = null,
    val wednesday: DayDbDto? = null,
    val thursday: DayDbDto? = null,
    val friday: DayDbDto? = null,
    val saturday: DayDbDto? = null,
    val sunday: DayDbDto? = null,
) : DbDtoType {
    override fun toDomain() = Week(
        monday = monday?.toDomain(),
        tuesday = tuesday?.toDomain(),
        wednesday = wednesday?.toDomain(),
        thursday = thursday?.toDomain(),
        friday = friday?.toDomain(),
        saturday = saturday?.toDomain(),
        sunday = sunday?.toDomain(),
    )

    override fun toNetDto() = WeekNetDto(
        monday = monday?.toNetDto(),
        tuesday = tuesday?.toNetDto(),
        wednesday = wednesday?.toNetDto(),
        thursday = thursday?.toNetDto(),
        friday = friday?.toNetDto(),
        saturday = saturday?.toNetDto(),
        sunday = sunday?.toNetDto(),
    )
}