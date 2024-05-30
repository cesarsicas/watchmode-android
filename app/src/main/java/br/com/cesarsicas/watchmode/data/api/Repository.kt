package br.com.cesarsicas.watchmode.data.api

import br.com.cesarsicas.watchmode.domain.Movie

class Repository() {

    private val service = watchModeApi.create(WatchModeService::class.java)

    suspend fun getReleases(): List<Movie> {
        return service.getReleases(apiKey).map { it.toMovie() }
    }

}