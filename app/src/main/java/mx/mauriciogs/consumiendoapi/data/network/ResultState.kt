package mx.mauriciogs.consumiendoapi.data.network

import mx.mauriciogs.consumiendoapi.domain.model.Characters

sealed class ResultState<out T> {

    data class Success<out T>(val data: T): ResultState<T>() {
        operator fun get(i: Int): Characters {
            TODO("Not yet implemented")
        }
    }

    data class Error<T>(val message: String?): ResultState<T>()

}
