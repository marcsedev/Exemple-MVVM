package com.marcsogasdev.exemplemvvm.data.model

import com.google.gson.annotations.SerializedName

//this is a data model

data class QuoteModel (@SerializedName("quote") val quote:String,
                       @SerializedName("author") val author:String)