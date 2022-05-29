package dependencies.libs

import dependencies.Dependency
import dependencies.provider.DependencyProvider
import dependencies.values

object QrReaderLibs : DependencyProvider {

    const val VERSION_MLKIT = "17.0.2"
    const val VERSION_ZXING = "3.4.1"

    override fun dependencies() = listOf(
        Dependency("com.google.mlkit", "barcode-scanning", VERSION_MLKIT),
        Dependency("com.google.zxing", "core", VERSION_ZXING)
    ).values()
}