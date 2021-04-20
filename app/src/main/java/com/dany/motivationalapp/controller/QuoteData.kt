package com.dany.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.dany.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class QuoteData {

    private val quoteArrayList: ArrayList<Quote> = ArrayList<Quote>()

    fun getQuetes(callback: QuoteListAsyncResponse) {
        val url =
            "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(
            Request.Method.GET, url, null, Response.Listener
            { response: JSONArray ->
                //var arrayList: ArrayList<Quote> = arrayListOf<Quote>()

                try {

                    (0 until response.length())
                        .map { response.getJSONObject(it) }
                        .mapTo(quoteArrayList) { Quote(it.getString("quote"), it.getString("name")) }


                    //Loop through the array:
//                    for (i in 0 until response.length()) {
//
//                        // Getting the Json Object inside the array:
//                        var quoteObject = response.getJSONObject(i)
//                        var quote =
//                            Quote(quoteObject.getString("quote"), quoteObject.getString("name"))
//
//                        quoteArrayList.add(quote)

//                        Log.d("===>Author:", quote.author)
//                    Log.d("===>Quotes:", quote.quote)
//                     }

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                callback.processFinished(quoteArrayList)
            },
            Response.ErrorListener { error: VolleyError ->
                try {
                    Log.d("Error", error.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            })
        AppController.instance!!.addToRequestQueue(quoteRequest)
    }
}
