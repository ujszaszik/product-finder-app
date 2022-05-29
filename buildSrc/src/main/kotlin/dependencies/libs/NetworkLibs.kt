package dependencies.libs

import dependencies.Dependency
import dependencies.provider.DependencyProvider
import dependencies.values

object NetworkLibs : DependencyProvider {

    const val VERSION_KTOR = "1.5.0"

    override fun dependencies() = listOf(
        Dependency("io.ktor", "ktor-client-android", VERSION_KTOR),
        Dependency("io.ktor", "ktor-client-serialization", VERSION_KTOR),
        Dependency("io.ktor", "ktor-client-logging-jvm", VERSION_KTOR),
    ).values()
}