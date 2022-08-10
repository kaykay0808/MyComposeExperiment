package com.example.mykotlin

import java.io.IOException
import java.lang.NullPointerException
import kotlin.Exception

fun main () {
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())

    Repository.finishedFetch()
    getResult(result = Repository.getCurrentState())

    Repository.error()
    getResult(result = Repository.getCurrentState())

    Repository.anotherCustomFailure()
    getResult(result = Repository.getCurrentState())

    Repository.customFailure()
    getResult(result = Repository.getCurrentState())

}


fun getResult(result: ResultAbstract) {
    return when (result) {
        is Error -> {
            println(result.exception.toString())
        }
        is Success -> {
            println(result.dataFetched?:  "Ensure you start the fetch function first")
        }
        is Loading -> {
            println("Loading...")
        }
        is NotLoading -> {
            println("Idle")
        }
        // else -> println("N/A")
        is Failure.AnotherCustomFailure -> {
            println(result.anotherCustomFailure.toString())
        }
        is Failure.CustomFailure -> {
            println(result.customFailure.toString())
        }
    }
}

object Repository {
    private var loadState: ResultAbstract = NotLoading /*Result.IDLE*/
    private var dataFetched:String? = null

    fun startFetch() {
        loadState = Loading /*Result.LOADING*/
        dataFetched = "data"
    }

    fun finishedFetch () {
        loadState = Success(dataFetched)
        dataFetched = null
    }

    fun error () {
        loadState = Error(exception = Exception("Exception"))
    }

    fun getCurrentState(): ResultAbstract {
        return loadState
    }

    fun anotherCustomFailure() {
        loadState = Failure.AnotherCustomFailure(anotherCustomFailure = NullPointerException("Something went wrong"))
    }

    fun customFailure() {
        loadState = Failure.CustomFailure(customFailure = IOException("Custom Failure"))
    }
}

// Sealed class get the freedom of representing our states differently.
// A Sealed Class is an abstract class with a restricted class hierarchy.
// Which mean classes that inherit from it have to be in the same file as a seal class.
sealed /*abstract*/ class ResultAbstract

data class Success(val dataFetched: String?): ResultAbstract()
data class Error(val exception: Exception): ResultAbstract()
// not emitting anything
object NotLoading: ResultAbstract()
object Loading: ResultAbstract()

sealed class Failure: ResultAbstract() {
    data class CustomFailure(val customFailure: IOException): Failure()
    data class AnotherCustomFailure(val anotherCustomFailure: NullPointerException): Failure()
}

/*enum class Result {
    SUCCESS,
    ERROR,
    LOADING,
    IDLE
}*/
