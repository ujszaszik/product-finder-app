package ch.galaxus.productfinder.network

sealed class Resource<out T : Any> {

    class Success<out T : Any>(val data: T) : Resource<T>()

    class Error<out T : Any>(val message: String) : Resource<T>()

    class Loading<out T : Any> : Resource<T>()
}