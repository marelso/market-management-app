package io.marelso.marketmanagement.data

open class Route(open val route: String)

fun Route.navigate(to: Route, vararg parameters: Pair<String, String>?): String {
    return parameters.fold(to.route) { route, parameter ->
        parameter?.let {
            route.replace("{${it.first}}", it.second)
        } ?: route
    }
}