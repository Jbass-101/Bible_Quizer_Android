package com.jbaloji.biblequiz.domain.model

/*Generic of sub type to a generic of supertype
* Producer values of type T through functions but not consume them
* Read Only -> Producer position, can not modify any variable of type T*/
sealed class Response<out T> {

    object Loading: Response<Nothing>()

    data class Success<out T>(
        val data: T
    ) : Response<T>()

    data class Failure(
        val e: Exception?
    ) : Response<Nothing>()

}