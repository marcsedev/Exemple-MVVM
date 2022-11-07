package com.marcsogasdev.exemplemvvm.data

import com.marcsogasdev.exemplemvvm.data.model.QuoteModel
import com.marcsogasdev.exemplemvvm.data.model.QuoteProvider
import com.marcsogasdev.exemplemvvm.data.network.QuoteService

class QuoteRepository {
    //classe a la que llamas para que devuelva las citas
    private val api = QuoteService()
// corrutina
    suspend fun getAllQuotes():List<QuoteModel>{
        val response : List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}