package com.slowcdw.myapplication.data.source

import com.slowcdw.myapplication.R
import com.slowcdw.myapplication.data.models.Actor
import com.slowcdw.myapplication.data.models.Movie

class MoviesDataSource {
    fun getMovies(): List<Movie>{
        return listOf(
            Movie("Avengers: End Game", R.drawable.movie_list_1, "Action, Adventure, Drama", 4f, 137, 13, false, 125,
                    "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies" +
                    ", the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
                    listOf(Actor("Robert Downey Jr.", R.drawable.movie_3), Actor("Chris Evans", R.drawable.movie_2), Actor("Mark Ruffalo"
                            , R.drawable.movie_1), Actor("Chris Hemsworth", R.drawable.movie_))),
            Movie("Tenet", R.drawable.movie_list_2, "Action, Sci-Fi, Thriller", 5f, 97, 16, true, 98,
                    "Action, Sci-Fi, Thriller Action, Sci-Fi, Thriller",
                    listOf(Actor("1Robert Downey Jr.", R.drawable.movie_3), Actor("1Chris Evans", R.drawable.movie_2), Actor("1ark Ruffalo"
                            , R.drawable.movie_1), Actor("1Chris Hemsworth", R.drawable.movie_))),
            Movie("Black Widow", R.drawable.movie_list_3, "Action, Adventure, Sci-Fi", 4f, 102, 13, false, 38,
            "Black Widow Black Widow Black Widow",
                    listOf(Actor("2Robert Downey Jr.", R.drawable.movie_3), Actor("2Chris Evans", R.drawable.movie_2), Actor("2Mark Ruffalo"
                            , R.drawable.movie_1), Actor("2Chris Hemsworth", R.drawable.movie_))),
            Movie("Wonder Woman 1984", R.drawable.movie_list_4, "Action, Adventure, Fantasy", 5f, 120, 13, false, 74,
            "Wonder Woman 1984 Wonder Woman 1984 Wonder Woman 1984",
                    listOf(Actor("3Robert Downey Jr.", R.drawable.movie_3), Actor("3Chris Evans", R.drawable.movie_2), Actor("3Mark Ruffalo"
                            , R.drawable.movie_1), Actor("3Chris Hemsworth", R.drawable.movie_)))
        )
    }
}