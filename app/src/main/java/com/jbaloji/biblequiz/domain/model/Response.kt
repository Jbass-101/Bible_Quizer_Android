package com.jbaloji.biblequiz.domain.model

import com.jbaloji.biblequiz.core.FileResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/*Generic of sub type to a generic of supertype
* Producer values of type T through functions but not consume them
* Read Only -> Producer position, can not modify any variable of type T*/
sealed class Response<out T> {

    object Loading: Response<Nothing>()

    data class Success<out T>(
        val data: T
    ) : Response<T>(), Flow<T> {
        override suspend fun collect(collector: FlowCollector<T>) {
            TODO("Not yet implemented")
        }
    }

    data class Failure(
        val e: Exception?
    ) : Response<Nothing>()

}