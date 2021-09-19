package ru.andreikud.simplecachingapp.util

import kotlinx.coroutines.flow.*
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType

inline fun <DbType, NetworkType> networkBoundResource(
    crossinline dbQuery: () -> Flow<DbType>,
    crossinline netQuery: suspend () -> NetworkType,
    crossinline saveNetToDb: suspend (NetworkType) -> Unit,
    crossinline dbDtoToNetDto: (DbType) -> NetworkType,
    crossinline netDtoToDbDto: (NetworkType) -> DbType,
    crossinline shouldNetQuery: (DbType) -> Boolean = { true },
) = flow {
    val dbData = dbQuery().first()

    val flow = if (shouldNetQuery(dbData)) {
        emit(Resource.Loading(dbData.map { it.toDomain() }))

        try {
            val netData = netQuery()
            saveNetToDb(netData)
            dbQuery().map { Resource.Success(it.toDomain()) }
        } catch (e: Throwable) {
            dbQuery().map { Resource.Error(e.localizedMessage, it.toDomain()) }
        }
    } else {
        dbQuery().map { Resource.Success(it.toDomain()) }
    }

    emitAll(flow)
}