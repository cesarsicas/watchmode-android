package br.com.cesarsicas.watchmode.data.api


import br.com.cesarsicas.watchmode.data.model.ReleaseSuccessResponse
import br.com.cesarsicas.watchmode.data.model.TitleDetailsSuccessResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchModeService {

    @GET("releases/")
    suspend fun getReleases(
        @Query("apiKey") apiKey: String
    ): ReleaseSuccessResponse


    @GET("title/{titleId}/details/")
    suspend fun getTitleDetails(
        @Path("titleId") titleId: Int,
        @Query("apiKey") apiKey: String
    ): TitleDetailsSuccessResponse

}