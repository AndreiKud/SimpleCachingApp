package ru.andreikud.simplecachingapp.data.model.dto

import ru.andreikud.simplecachingapp.data.model.domain.DomainType

interface DtoType {
    fun toDomain(): DomainType
}