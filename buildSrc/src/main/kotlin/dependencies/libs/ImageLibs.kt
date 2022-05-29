package dependencies.libs

import dependencies.Dependency
import dependencies.provider.DependencyProvider
import dependencies.values

object ImageLibs : DependencyProvider {

    const val VERSION_COIL = "2.0.0-rc02"

    override fun dependencies() = listOf(
        Dependency("io.coil-kt", "coil-compose", VERSION_COIL),
    ).values()

}