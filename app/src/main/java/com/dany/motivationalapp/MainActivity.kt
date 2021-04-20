package com.dany.motivationalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.dany.motivationalapp.controller.AppController
import com.dany.motivationalapp.controller.QuoteData
import com.dany.motivationalapp.controller.QuoteListAsyncResponse
import com.dany.motivationalapp.controller.QuoteViewPagerAdapter
import com.dany.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewPagerAdapter: QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager, getFragments())
        viewPager.adapter = quoteViewPagerAdapter
                }

    fun getFragments(): ArrayList<QuoteFragment> {

//        lateinit var fragmentList: ArrayList<QuoteFragment>

        val fragmentList = ArrayList<QuoteFragment>()

        QuoteData().getQuetes(object : QuoteListAsyncResponse {
            override fun processFinished(quotes: ArrayList<Quote>) {

                (0 until quotes.size).mapTo(fragmentList) {
                    QuoteFragment.newInstance(
                        quotes[it].quote,
                        quotes[it].author
                    )
                }
                quoteViewPagerAdapter.notifyDataSetChanged()
            }
        })
        return fragmentList
    }
}