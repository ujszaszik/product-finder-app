package ch.galaxus.productfinder.network.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientModule {

    private const val TIME_OUT = 30_000 // ms

    @Provides
    @Singleton
    fun provideHttpClient(
        kotlinXSerializer: KotlinxSerializer,
        clientLogger: Logger
    ): HttpClient {

        return HttpClient(Android) {

            install(JsonFeature) {
                serializer = kotlinXSerializer

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }
            }

            install(Logging) {
                logger = clientLogger
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Timber.tag("API Status Code:").d("${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("user-agent", System.getProperty("http.agent"))
            }
        }
    }

    @Provides
    fun provideSerializer(): KotlinxSerializer {
        return KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return object : Logger {
            override fun log(message: String) {
                Timber.tag("API Log: ").d(message)
            }
        }
    }
}