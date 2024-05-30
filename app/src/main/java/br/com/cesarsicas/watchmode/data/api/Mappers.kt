package br.com.cesarsicas.watchmode.data.api

import br.com.cesarsicas.watchmode.data.model.ReleaseSuccessResponse
import br.com.cesarsicas.watchmode.domain.Movie


fun ReleaseSuccessResponse.Release.toMovie(): Movie {

    return Movie(
        title = title,
        poster = poster_url,
        description = ""
    )
}