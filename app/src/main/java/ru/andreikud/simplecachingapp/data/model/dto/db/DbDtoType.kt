package ru.andreikud.simplecachingapp.data.model.dto.db

import ru.andreikud.simplecachingapp.data.model.domain.DomainType
import ru.andreikud.simplecachingapp.data.model.dto.DtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType

interface DbDtoType : DtoType {
    fun toNetDto(): NetDtoType
}