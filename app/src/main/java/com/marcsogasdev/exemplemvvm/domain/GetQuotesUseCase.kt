package com.marcsogasdev.exemplemvvm.domain

import com.marcsogasdev.exemplemvvm.data.QuoteRepository
import com.marcsogasdev.exemplemvvm.data.model.QuoteModel

class GetQuotesUseCase {
    //casos de uso
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}