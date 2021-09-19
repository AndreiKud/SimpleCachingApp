package ru.andreikud.simplecachingapp.data.model.dto.network

import ru.andreikud.simplecachingapp.data.model.domain.DomainType
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType

interface NetDtoType {
    fun toDomain(): DomainType
    fun toDbDto(): DbDtoType
}