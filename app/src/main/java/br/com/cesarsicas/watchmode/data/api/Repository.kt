package br.com.cesarsicas.watchmode.data.api

import br.com.cesarsicas.watchmode.domain.Title

class Repository() {

    private val service = watchModeApi.create(WatchModeService::class.java)

    suspend fun getReleases(): List<Title> {
        return service.getReleases(apiKey).releases.map { it.toTitle() }
    }

    suspend fun getTitleDetails(titleId: Int): Title {
        return service.getTitleDetails(titleId, apiKey).toTitle()
    }

    suspend fun getSearch(search: String): List<Title> {
        return service.getSearch(apiKey, search).results.map { it.toTitle() }
    }
}


