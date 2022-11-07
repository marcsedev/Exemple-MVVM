package com.marcsogasdev.exemplemvvm.data.network

import com.marcsogasdev.exemplemvvm.core.RetrofitHelper
import com.marcsogasdev.exemplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {
    //Chose si la saca de internet o de la base de datos

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        //corrutins (no hilo principal) llamada al servidor
        return withContext(Dispatchers.IO) {
            //get all quotes
            val response: Response<List<QuoteModel>> =
                retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()

        }
    }

}