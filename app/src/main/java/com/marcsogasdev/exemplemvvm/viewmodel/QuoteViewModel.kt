package com.marcsogasdev.exemplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcsogasdev.exemplemvvm.model.QuoteModel
import com.marcsogasdev.exemplemvvm.model.QuoteProvider


class QuoteViewModel : ViewModel(){
   //live data subscribe a data model an cll him when there ara changes

    val quoteModel=MutableLiveData<QuoteModel>()

    //when user push screen call this
    fun randomQuote(){
        val currentQuote : QuoteModel = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}