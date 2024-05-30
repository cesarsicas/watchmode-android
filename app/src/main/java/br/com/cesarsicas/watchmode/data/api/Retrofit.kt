package br.com.cesarsicas.watchmode.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal val watchModeApi = Retrofit.Builder()
    .baseUrl("https://api.watchmode.com/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()