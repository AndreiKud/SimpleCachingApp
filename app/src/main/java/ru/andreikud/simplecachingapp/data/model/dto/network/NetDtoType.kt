package ru.andreikud.simplecachingapp.data.model.dto.network

import ru.andreikud.simplecachingapp.data.model.domain.DomainType
import ru.andreikud.simplecachingapp.data.model.dto.DtoType
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType

interface NetDtoType : DtoType {
    fun toDbDto(): DbDtoType
}