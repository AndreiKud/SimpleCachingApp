package ru.andreikud.simplecachingapp.data.model

import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.DayDto
import ru.andreikud.simplecachingapp.data.model.dto.RestaurantDto

fun DayDto.toDomain() = Day(
    closesAt = closesAt,
    opensAt = opensAt,
    isClosed = isClosed,
)

fun RestaurantDto.toDomain() = Restaurant(
    address = address,
    description = description,
    logo = logo,
    hours = hours?.map(DayDto::toDomain),
    name = name,
    id = id,
    phoneNumber = phoneNumber,
    review = review,
    type = type,
    uid = uid,
)