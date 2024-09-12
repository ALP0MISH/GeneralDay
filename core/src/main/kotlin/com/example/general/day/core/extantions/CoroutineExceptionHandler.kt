package com.example.general.day.core.extantions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

/**
 * The callSafe function allows for safe execution of a suspend block of code,
 * with the ability to specify a default value in case of an exception.
 *
 * @param block - A suspend function that contains the code to be executed safely.
 *
 * @return The result of the suspend block execution, or the specified default value if an exception occurs.
 *
 * @throws CancellationException if the coroutine is canceled during execution.
 */

private const val ErrorAPICall = "Ошибка во время вызова API"

suspend fun <T> callSafe(
    dispatcher: CoroutineDispatcher,
    block: suspend () -> T
): T {
    return withContext(dispatcher) {
        try {
            block()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException("$ErrorAPICall:${e.message}", e)
        }
    }
}