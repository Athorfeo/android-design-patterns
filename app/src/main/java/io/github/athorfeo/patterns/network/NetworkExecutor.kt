package io.github.athorfeo.patterns.network

import io.github.athorfeo.patterns.di.IoDispatcher
import io.github.athorfeo.patterns.util.AppException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NetworkExecutor @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val networkConnectionHelper: NetworkConnectionHelper
) {
    suspend fun <T> fetch(service: suspend () -> Response<T>): T? = withContext(dispatcher) {
        if(!networkConnectionHelper.hasNetworkConnection) {
            throw AppException()
        }

        val response = service()

        if (response.isSuccessful) {
            response.body()
        } else {
            throw AppException()
        }
    }
}
