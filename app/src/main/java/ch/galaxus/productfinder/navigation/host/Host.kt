package ch.galaxus.productfinder.navigation.host

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Host(
    var route: String,
    val backPressStrategy: BackPressStrategy = BackPressStrategy.POP_BACKSTACK
)

@OptIn(ExperimentalSerializationApi::class)
fun Host.compress(): String = Json.encodeToString(this)

@OptIn(ExperimentalSerializationApi::class)
fun String.extractHost(): Host? = Json.decodeFromString(this)

// path/{param}
fun Host.acceptParam(param: String): Host = apply {
    route = StringBuilder().apply {
        append(route)
        append("/{")
        append(param)
        append("}")
    }.toString()
}

@OptIn(ExperimentalSerializationApi::class)
inline fun <reified T> Host.withData(data: T?): String {
    return route.plus(Json.encodeToString(data))
}