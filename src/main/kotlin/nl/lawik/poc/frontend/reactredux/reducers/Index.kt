package nl.lawik.poc.frontend.reactredux.reducers

import nl.lawik.poc.frontend.reactredux.entities.Todo
import nl.lawik.poc.frontend.reactredux.enums.VisibilityFilter
import nl.lawik.poc.frontend.reactredux.util.combineReducers
import redux.Action
import redux.RAction


data class State(
    val todos: Array<Todo> = emptyArray(),
    val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL
)

fun combinedReducers() = combineReducers(
    mapOf(
        State::todos to ::todos,
        State::visibilityFilter to ::visibilityFilter
    )
)

fun rootReducer(
    state: State,
    action: Any
) = State(
    todos(state.todos, action.unsafeCast<RAction>()),
    visibilityFilter(state.visibilityFilter, action.unsafeCast<RAction>()),
)