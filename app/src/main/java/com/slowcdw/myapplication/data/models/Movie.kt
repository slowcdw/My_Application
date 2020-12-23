package com.slowcdw.myapplication.data.models

data class Movie(
        val name: String,
        val image: Int,
        val genre: String,
        val rating: Float,
        val duration: Int,
        val age: Int,
        val like: Boolean,
        val reviews: Int,
        val content: String,
        val actors: List<Actor>
)