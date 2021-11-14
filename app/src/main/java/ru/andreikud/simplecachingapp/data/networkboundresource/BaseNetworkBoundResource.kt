package ru.andreikud.simplecachingapp.data.networkboundresource

import kotlinx.coroutines.flow.*
import ru.andreikud.simplecachingapp.data.model.domain.DomainType
import ru.andreikud.simplecachingapp.data.model.dto.DtoType
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType
import ru.andreikud.simplecachingapp.util.Resource

/**
 * Base class for implementing NetworkBoundResource pattern.
 * Returns domain model, retrieving it from cache and remote data-sources.
 */
abstract class BaseNetworkBoundResource<Db, Net, Dom> {
    suspend fun getResource() = flow {
        val dbData = dbQuery().first()

        // Should we try to get a new data, or simply showing the cached one.
        if (shouldNetQuery(dbData)) {

            // Emitting cached data.
            emit(Resource.Loading(dbToDomain(dbData)))

            // Trying to get fresh data.
            try {
                val netData = netQuery()
                saveNetToDb(netData)
                emit(Resource.Success(netToDomain(netData)))
            } catch (e: Throwable) {
                emit(Resource.Error(e.localizedMessage))
            }
        } else {
            emit(Resource.Success(dbToDomain(dbData)))
        }
    }

    protected abstract fun netToDomain(netData: Net): Dom
    protected abstract fun dbToDomain(dbData: Db): Dom
    protected abstract fun shouldNetQuery(dbData: Db): Boolean
    protected abstract fun dbQuery(): Flow<Db>
    protected abstract suspend fun saveNetToDb(netData: Net)
    protected abstract suspend fun netQuery(): Net
}