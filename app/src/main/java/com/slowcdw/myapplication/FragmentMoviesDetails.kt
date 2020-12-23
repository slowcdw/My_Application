package com.slowcdw.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slowcdw.myapplication.data.models.Actor
import com.slowcdw.myapplication.data.source.MoviesDataSource

class FragmentMoviesDetails : Fragment() {
    private var listener: FragmentMoviesList.TransactionsFragmentClicks? = null
    private var movieId: Int = 0
    private var recycler: RecyclerView? = null
    private lateinit var adapter: ActorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("1q1","onCreate")
        arguments?.let {
            movieId = it.getInt(PARAM_ID)
//            Log.d("1q1","movieId = $movieId")
        }
    }

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

        recycler = view.findViewById(R.id.rv_actors)
        adapter = ActorsAdapter()
        recycler?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recycler?.adapter = adapter

//        Log.d("1q1","onViewCreated = $movieId")
        val movie = MoviesDataSource().getMovies()[movieId]
        val genre = view.findViewById<TextView>(R.id.tv_genre)
        val rating = view.findViewById<RatingBar>(R.id.iv_star_5)
        val reviews = view.findViewById<TextView>(R.id.tv_reviews)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val content = view.findViewById<TextView>(R.id.tv_content)
        val name = view.findViewById<TextView>(R.id.tv_caption)

        genre.text = movie.genre
        rating.rating = movie.rating
        reviews.text = movie.reviews.toString() + " REVIEWS"
        age.text = movie.age.toString() + "+"
        content.text = movie.content
        name.text = movie.name
//        Log.d("1q1","movie.name = $movie.name")
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

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        adapter.bindActors(MoviesDataSource().getMovies()[movieId].let { it.actors })
        adapter.notifyDataSetChanged()
    }

    fun setClickListener(l: FragmentMoviesList.TransactionsFragmentClicks?) {
        listener = l
    }

    companion object {
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
    }
}