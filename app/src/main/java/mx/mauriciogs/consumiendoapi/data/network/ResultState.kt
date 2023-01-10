package mx.mauriciogs.consumiendoapi.data.network

import mx.mauriciogs.consumiendoapi.domain.model.Characters

sealed class ResultState<out T> {

    data class Success<out T>(val data: T): ResultState<T>()

    data class Error<T>(val message: String?): ResultState<T>()

}
