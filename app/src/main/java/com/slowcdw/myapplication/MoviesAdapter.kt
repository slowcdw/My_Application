package com.slowcdw.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slowcdw.myapplication.data.models.Movie

class MoviesAdapter(
        private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<DataViewHolder>() {
    private var movies: List<Movie> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        Log.d("1q1","Adapter = $position")
        holder.onBind(movies[position])
        holder.itemView.setOnClickListener{
            clickListener.onClick(position)
        }
    }

    override fun getItemCount(): Int = movies.count()

    fun bindMovies(newMovies: List<Movie>){
        movies = newMovies
    }
}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    companion object{
//        private val imageOption = RequestOptions()
//                .placeholder(R.drawable.ic_avatar_placeholder)
//                .fallback(R.drawable.ic_avatar_placeholder)
//                .circleCrop()
//
//    }

    private val name: TextView = itemView.findViewById(R.id.title_films)
    private val image: ImageView = itemView.findViewById(R.id.preview_img_1)
    private val genre: TextView = itemView.findViewById(R.id.tv_genre)
    private val rating: RatingBar = itemView.findViewById(R.id.iv_star_5)
    private val duration: TextView = itemView.findViewById(R.id.duration)
    private val age: TextView = itemView.findViewById(R.id.age)
    private val like: ImageView = itemView.findViewById(R.id.iv_like)
    private val reviews: TextView = itemView.findViewById(R.id.tv_reviews)

    fun onBind(movie: Movie){
        name.text = movie.name
        image.setImageResource(movie.image)
        genre.text = movie.genre
        rating.rating = movie.rating
        duration.text = movie.duration.toString() + " MIN"
        age.text = movie.age.toString() + "+"
        reviews.text = movie.reviews.toString() + " REVIEWS"
        if (movie.like) like.setImageResource(R.drawable.like_red)

    }
}
private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(moviePosition: Int)
}