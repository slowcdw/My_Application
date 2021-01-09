package com.slowcdw.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.slowcdw.myapplication.data.models.Movie

class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks {

//    private var moviePosition: Int = 0
    private val rootFragment =
            FragmentMoviesList.newInstance().apply { setClickListener(this@MainActivity) }

//    private val detailsFragment =
//            FragmentMoviesDetails.newInstance(moviePosition).apply { setClickListener(this@MainActivity) }

    private var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .apply {
                    //add(R.id.main_container, FragmentMoviesDetails())
                    add(R.id.main_container, rootFragment)
                    commit()
                }

    }

    override fun addDetailsFragment(moviePosition: Int) {
        val detailsFragment =
            FragmentMoviesDetails.newInstance(moviePosition).apply { setClickListener(this@MainActivity) }
        supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.main_container, detailsFragment)
                    commit()
                }
    }

    override fun backFragment() {
        val lastFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.beginTransaction().apply {
            remove(lastFragment)
            commit()
        }
    }
}