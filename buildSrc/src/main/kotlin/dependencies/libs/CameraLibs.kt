package dependencies.libs

import dependencies.Dependency
import dependencies.provider.DependencyProvider
import dependencies.values

object CameraLibs : DependencyProvider {
    const val VERSION_CAMERA_X = "1.1.0-beta01"

    override fun dependencies() = listOf(
        Dependency("androidx.camera", "camera-core", VERSION_CAMERA_X),
        Dependency("androidx.camera", "camera-camera2", VERSION_CAMERA_X),
        Dependency("androidx.camera", "camera-lifecycle", VERSION_CAMERA_X),
        Dependency("androidx.camera", "camera-extensions", VERSION_CAMERA_X),
        Dependency("androidx.camera", "camera-view", VERSION_CAMERA_X)
    ).values()
}