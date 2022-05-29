package ch.galaxus.productfinder.network

import java.net.SocketTimeoutException

object NetworkErrorHandler {

    fun getErrorMessageByThrowable(throwable: Throwable): String {
        return if (!NetworkUtil.isConnected) ApiErrorCodes.NO_CONNECTION.message
        else if (throwable is SocketTimeoutException) ApiErrorCodes.TIMEOUT.message
        else ApiErrorCodes.DEFAULT.message
    }
}