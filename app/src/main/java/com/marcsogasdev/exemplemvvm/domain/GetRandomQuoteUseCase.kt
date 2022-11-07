package com.marcsogasdev.exemplemvvm.domain

import com.marcsogasdev.exemplemvvm.data.model.QuoteModel
import com.marcsogasdev.exemplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
   // private val repository = QuoteRepository()

    operator fun invoke():QuoteModel?{
        // repository.getAllQuotes()

        //not correct
        //recupera un listado de quotes, si no esta vacio return una  si no null
        val quotes : List<QuoteModel> = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size -1).random()
            return quotes[randomNumber]
        }
        return null
    }
}