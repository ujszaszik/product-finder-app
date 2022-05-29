package ch.galaxus.productfinder.navigation.arguments

import androidx.navigation.NavBackStackEntry
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

inline fun <reified T> NavBackStackEntry.retainParam(param: String): T? {
    return try {
        arguments?.getString(param)?.substring(param.length + 2)?.convertFromJson()
    } catch (thr: Throwable) {
        null
    }
}

@OptIn(ExperimentalSerializationApi::class)
inline fun <reified T> String.convertFromJson(): T? {
    return Json.decodeFromString(this)
}