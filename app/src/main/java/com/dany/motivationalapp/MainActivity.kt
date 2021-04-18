package com.dany.motivationalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.dany.motivationalapp.controller.AppController
import com.dany.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"
        getInfo(url)
    }

    // Fetching the information.
    fun getInfo(url: String) {

        val quoteRequest = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener
        { response: JSONArray ->
            try {

                //Loop through the array:
                for(i in 0 until response.length()){

                    // Getting the Json Object inside the array:
                    var quoteObject = response.getJSONObject(i)
                    var quote = Quote(quoteObject.getString("quote"), quoteObject.getString("name"))

                    Log.d("===>Author:", quote.author)
//                    Log.d("===>Quotes:", quote.quote)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
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