package ru.andreikud.simplecachingapp.data.model.dto.network

import ru.andreikud.simplecachingapp.data.model.domain.Week
import ru.andreikud.simplecachingapp.data.model.dto.db.WeekDbDto

class WeekNetDto(
    val monday: DayNetDto? = null,
    val tuesday: DayNetDto? = null,
    val wednesday: DayNetDto? = null,
    val thursday: DayNetDto? = null,
    val friday: DayNetDto? = null,
    val saturday: DayNetDto? = null,
    val sunday: DayNetDto? = null,
) : NetDtoType {

    override fun toDomain() = Week(
        monday = monday?.toDomain(),
        tuesday = tuesday?.toDomain(),
        wednesday = wednesday?.toDomain(),
        thursday = thursday?.toDomain(),
        friday = friday?.toDomain(),
        saturday = saturday?.toDomain(),
        sunday = sunday?.toDomain(),
    )

    override fun toDbDto() = WeekDbDto(
        monday = monday?.toDbDto(),
        tuesday = tuesday?.toDbDto(),
        wednesday = wednesday?.toDbDto(),
        thursday = thursday?.toDbDto(),
        friday = friday?.toDbDto(),
        saturday = saturday?.toDbDto(),
        sunday = sunday?.toDbDto(),
    )
}