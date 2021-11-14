package ru.andreikud.simplecachingapp.data.networkboundresource

import kotlinx.coroutines.flow.*
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType

//inline fun <T> networkBoundResource(
//    crossinline dbQuery: () -> Flow<List<DbDtoType>>,
//    crossinline netQuery: suspend () -> List<NetDtoType>,
//    crossinline saveNetToDb: suspend (List<NetDtoType>) -> Unit,
//    crossinline shouldNetQuery: (List<DbDtoType>) -> Boolean = { true },
//) = flow {
//    val dbData = dbQuery().first()
//
//    val flow = if (shouldNetQuery(dbData)) {
//        emit(Resource.Loading(dbData.map { it.toDomain() }))
//
//        try {
//            val netData = netQuery()
//            saveNetToDb(netData)
//            Resource.Success(netData.map { it.toDomain() })
//        } catch (e: Throwable) {
//            dbQuery().map { Resource.Error<T>(e.localizedMessage, it.toDomain()) }
//        }
//    } else {
//        dbQuery().map { objects -> Resource.Success<T>(objects.map { it.toDomain() } }
//    }
//
//    emitAll(flow)
//}