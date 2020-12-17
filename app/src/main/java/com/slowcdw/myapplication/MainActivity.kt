package com.slowcdw.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks {

    private val rootFragment =
            FragmentMoviesList().apply { setClickListener(this@MainActivity) }

    private val detailsFragment =
            FragmentMoviesDetails().apply { setClickListener(this@MainActivity) }

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

    override fun addDetailsFragment() {
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