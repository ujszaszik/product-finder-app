package ch.galaxus.productfinder.network

import ch.galaxus.productfinder.network.request.QueryRequest
import ch.galaxus.productfinder.network.response.QueryResponse
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

typealias ResourceFlow<T> = Flow<Resource<T>>

class WebClient @Inject constructor(
    val httpClient: HttpClient
) {

    companion object {
        const val BASE_URL = "https://www.galaxus.ch/api/graphql"
    }

    inline fun <reified R : QueryResponse> postQuery(queryString: String): ResourceFlow<R> {
        return flow {

            emit(Resource.Loading())

            try {
                val result = httpClient.post<R>(BASE_URL) {
                    body = QueryRequest(queryString)
                }
                emit(Resource.Success(result))
            } catch (thr: Throwable) {
                val errorMessage = NetworkErrorHandler.getErrorMessageByThrowable(thr)
                emit(Resource.Error(errorMessage))
            }

        }.flowOn(Dispatchers.IO)
    }

}