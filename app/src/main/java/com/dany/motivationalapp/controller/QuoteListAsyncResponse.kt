package com.dany.motivationalapp.controller

import com.dany.motivationalapp.model.Quote

interface QuoteListAsyncResponse {

    fun processFinished(quotes: ArrayList<Quote>)
}