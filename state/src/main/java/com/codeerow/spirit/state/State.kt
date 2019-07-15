package com.codeerow.spirit.state


/**
 * Describes current state.
 * */
sealed class State(val failures: List<Throwable> = listOf()) {
    class New : State()
    class Processing : State()
    class Failure(failures: List<Throwable>) : State(failures)
    class Success : State()


    companion object {
        /**
         * Calculate state value based on list of states.
         * */
        fun obtainState(statesValues: List<State?>): State {
            val failures = statesValues.map { it?.failures }
            val thisFailures = mutableListOf<Throwable>()

            val hasFailures = failures.map { it?.isNotEmpty() ?: false }.contains(true)
            val hasProcessing = statesValues.findLast { it is Processing } != null

            failures.forEach { it?.let(thisFailures::addAll) }
            return when {
                hasFailures -> Failure(thisFailures)
                hasProcessing -> Processing()
                else -> Success()
            }
        }
    }
}
