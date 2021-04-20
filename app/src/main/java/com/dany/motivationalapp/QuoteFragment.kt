package com.dany.motivationalapp


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import java.util.concurrent.ThreadLocalRandom


/**
 * A simple [Fragment] subclass.
 */
class QuoteFragment : Fragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater!!.inflate(R.layout.fragment_quote, container, false)


        //create views controlled by the fragment
        val quoteText = view.findViewById<TextView>(R.id.quoteText)
        val byAuthor = view.findViewById<TextView>(R.id.byAuthor)
        val cardView = view.findViewById<CardView>(R.id.cardView)


        var quote = arguments?.get("quote").toString()
        var author = arguments?.get("author").toString()


        quoteText.text = quote
        byAuthor.text = author

        val colors = intArrayOf(R.color.blue_500, R.color.pink_900, R.color.green_400, R.color.lime_400,
            R.color.orange_400, R.color.amber_800, R.color.pink_800, R.color.grey_700, R.color.green_50)

        cardView.setBackgroundResource(getRandomColor(colors))


        // Inflate the layout for this fragment
        return view
    }

    companion object {

        fun newInstance(quote: String, author: String): QuoteFragment {
            val fragment = QuoteFragment()
            val bundle = Bundle()
            bundle.putString("quote", quote)
            bundle.putString("author", author)

            fragment.arguments = bundle // this is how we pass information to between fragments and Activity

            return fragment

        }

    }

    private fun getRandomColor(colorArray: IntArray): Int { // make this function internal or private :)
        val color: Int
        val quotesArrayLen = colorArray.size

        val randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen)

        color = colorArray[randomNum]

        return color


    }


}// Required empty public constructor


//package com.dany.motivationalapp
//
//import android.graphics.Color
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import kotlinx.android.synthetic.main.fragment_quote.*
//
//class QuoteFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        var view = inflater.inflate(R.layout.fragment_quote, container, false)
//
//            var quote = arguments?.get("quote").toString()
//            var author = arguments?.get("author").toString()
//
//            quoteText.text = quote
//            byAuthor.text = author
//
//
//        cardView.setCardBackgroundColor(Color.parseColor("black"))
//
//
//        // Inflate the layout for this fragment
//        return view
//    }
//    fun newInstance(quote: String, author: String): QuoteFragment{
//        val fragment = QuoteFragment()
//        val bundle = Bundle()
//        bundle.putString("quote", quote)
//        bundle.putString("author", author)
//
//        fragment.arguments = bundle // This is for passing information between fragments and activity
//
//        return fragment
//    }
//}