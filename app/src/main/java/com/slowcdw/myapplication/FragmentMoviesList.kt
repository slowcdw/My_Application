package com.slowcdw.myapplication

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.slowcdw.myapplication.data.models.Movie
import com.slowcdw.myapplication.data.source.MoviesDataSource
import com.slowcdw.myapplication.utils.calculateNoOfColumns


class FragmentMoviesList : Fragment() {
    private var recycler: RecyclerView? = null
    private lateinit var adapter: MoviesAdapter
//    private var viewFilm: View? = null
    private var listener: TransactionsFragmentClicks? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        /*val img= view.findViewById<ImageView>(R.id.preview_img_1);
        val bitmap = BitmapFactory.decodeResource(resources,R.drawable.movie_list_1);
        val dr = RoundedBitmapDrawableFactory.create(resources, bitmap);
        dr.cornerRadius = 8F;
        img.setImageDrawable(dr);*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.rv_movie)
        adapter = MoviesAdapter(clickListener)
//        recycler.layoutManager = LinearLayoutManager(requireContext())

        val padding = 8
        val mNoOfColumns: Int = calculateNoOfColumns(requireContext(), 170f + padding)
//        Log.d("q1_mNoOfColumns", mNoOfColumns.toString())
        recycler?.layoutManager = GridLayoutManager(requireContext(), mNoOfColumns)
        recycler?.adapter = adapter
        recycler?.addItemDecoration(HorizantalSpaceItemDecoration(padding))


//        viewFilm = view.findViewById<View>(R.id.preview_border).apply {
//            setOnClickListener {
//                listener?.addDetailsFragment()
//            }
//        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        adapter.bindMovies(MoviesDataSource().getMovies())
        adapter.notifyDataSetChanged()
    }

    fun setClickListener(l: TransactionsFragmentClicks?) {
        listener = l
    }
    interface TransactionsFragmentClicks {
        fun addDetailsFragment(moviePosition: Int)
        fun backFragment()
    }

    private fun doOnClick(moviePosition: Int) {
//        Log.d("1q1","List = $moviePosition")
        recycler?.let {
            rv ->
            listener?.addDetailsFragment(moviePosition)
//            Snackbar.make(
//                    rv,
//                    "!!! $moviePosition",
//                    Snackbar.LENGTH_SHORT)
//                    .show()
        }
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(moviePosition: Int) {
            doOnClick(moviePosition)
        }
    }

    companion object{
        fun newInstance() = FragmentMoviesList()
    }
}
class HorizantalSpaceItemDecoration(private val mItemOffset: Int) : RecyclerView.ItemDecoration() {
//    private var mItemOffset = 0

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
//        outRect.right = 14
//        outRect.bottom = 50
    }
}