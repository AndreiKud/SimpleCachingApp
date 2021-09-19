package ru.andreikud.simplecachingapp.data.model.domain

import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType

interface DomainType {
    fun toDbDto(): DbDtoType
    fun toNetDto(): NetDtoType
}