package com.slowcdw.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .apply {
                    //add(R.id.main_container, FragmentMoviesDetails())
                    add(R.id.main_container, FragmentMoviesList())
                    commit()
                }
    }
}