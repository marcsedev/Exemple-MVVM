package com.marcsogasdev.exemplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcsogasdev.exemplemvvm.data.model.QuoteModel
import com.marcsogasdev.exemplemvvm.data.model.QuoteProvider
import com.marcsogasdev.exemplemvvm.domain.GetQuotesUseCase
import com.marcsogasdev.exemplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch


class QuoteViewModel : ViewModel(){
   //live data subscribe a data model an cll him when there ara changes

    val quoteModel=MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        //call to use case y almacene los casos en memoria
// la corrutina se controla automaticamente
        viewModelScope.launch {
            isLoading.postValue(true)
            val result : List<QuoteModel>? = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                //si no hay llamada pon la primera quote
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }

    }
    //when user push screen call this
    fun randomQuote(){//caso de uso
        isLoading.postValue(true)
        val quote = getRandomQuotesUseCase()
        if(quote!=null){
            quoteModel.postValue(quote!!)
        }



//        val currentQuote : QuoteModel = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
        isLoading.postValue(false)

    }


}