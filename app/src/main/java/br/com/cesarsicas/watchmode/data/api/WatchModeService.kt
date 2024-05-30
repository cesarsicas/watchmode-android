package br.com.cesarsicas.watchmode.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WatchModeService {

    @GET("releases/")
    suspend fun getReleases(@Query("apiKey") apiKey: String): List<Release>

}