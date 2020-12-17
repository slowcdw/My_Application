package com.slowcdw.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {
    private var listener: FragmentMoviesList.TransactionsFragmentClicks? = null

//    private var fragmentId: Int = 0
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fragmentId = it.getInt(PARAM_ID)
        }
        Toast.makeText(context, "id: " + fragmentId, Toast.LENGTH_SHORT).show()
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.arrow_back).apply {
            setOnClickListener {
                listener?.backFragment()
            }
        }
        view.findViewById<TextView>(R.id.text_back).apply {
            setOnClickListener {
                listener?.backFragment()
            }
        }
    }

    fun setClickListener(l: FragmentMoviesList.TransactionsFragmentClicks?) {
        listener = l
    }

    /*companion object {
        private const val PARAM_ID = "fragment_id"
        fun newInstance(
                id: Int
        ): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            val args = Bundle()
            args.putInt(PARAM_ID, id)
            fragment.arguments = args
            return fragment
        }
    }*/
}