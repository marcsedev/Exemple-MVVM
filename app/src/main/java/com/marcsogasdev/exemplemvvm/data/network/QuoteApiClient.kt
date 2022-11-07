package com.marcsogasdev.exemplemvvm.data.network

import com.marcsogasdev.exemplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    // return list of objects
    suspend fun getAllQuotes() :Response<List<QuoteModel>>
}