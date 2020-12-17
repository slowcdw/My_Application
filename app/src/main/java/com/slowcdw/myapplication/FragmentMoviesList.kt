package com.slowcdw.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private var viewFilm: View? = null
    private var listener: TransactionsFragmentClicks? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val img= view.findViewById<ImageView>(R.id.preview_img_1);
        val bitmap = BitmapFactory.decodeResource(resources,R.drawable.movie_list_1);
        val dr = RoundedBitmapDrawableFactory.create(resources, bitmap);
        dr.cornerRadius = 8F;
        img.setImageDrawable(dr);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewFilm = view.findViewById<View>(R.id.preview_border).apply {
            setOnClickListener {
                listener?.addDetailsFragment()
            }
        }
    }

    fun setClickListener(l: TransactionsFragmentClicks?) {
        listener = l
    }
    interface TransactionsFragmentClicks {
        fun addDetailsFragment()
        fun backFragment()
    }
}