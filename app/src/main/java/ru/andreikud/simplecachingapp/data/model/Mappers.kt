package ru.andreikud.simplecachingapp.data.model

import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.domain.Week
import ru.andreikud.simplecachingapp.data.model.dto.DayDto
import ru.andreikud.simplecachingapp.data.model.dto.RestaurantDto
import ru.andreikud.simplecachingapp.data.model.dto.WeekDto

fun RestaurantDto.toDomain() = Restaurant(
    address = address,
    description = description,
    logo = logo,
    weekSchedule = weekSchedule?.toDomain(),
    name = name,
    id = id,
    phoneNumber = phoneNumber,
    review = review,
    type = type,
    uid = uid,
)

fun WeekDto.toDomain() = Week(
    monday = monday?.toDomain(),
    tuesday = tuesday?.toDomain(),
    wednesday = wednesday?.toDomain(),
    thursday = thursday?.toDomain(),
    friday = friday?.toDomain(),
    saturday = saturday?.toDomain(),
    sunday = sunday?.toDomain(),
)

fun DayDto.toDomain() = Day(
    closesAt = closesAt,
    opensAt = opensAt,
    isClosed = isClosed,
)