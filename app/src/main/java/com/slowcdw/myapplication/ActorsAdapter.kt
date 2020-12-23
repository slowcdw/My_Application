package com.slowcdw.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slowcdw.myapplication.data.models.Actor

class ActorsAdapter(
//        private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<ActorDataViewHolder>() {
    private var actors: List<Actor> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorDataViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false)
        return ActorDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorDataViewHolder, position: Int) {
//        Log.d("1q1","Adapter = $position")
        holder.onBind(actors[position])
//        holder.itemView.setOnClickListener{
//            clickListener.onClick(position)
//        }
    }

    override fun getItemCount(): Int = actors.count()

    fun bindActors(newActors: List<Actor>){
        actors = newActors
    }

}

class ActorDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    companion object{
//        private val imageOption = RequestOptions()
//                .placeholder(R.drawable.ic_avatar_placeholder)
//                .fallback(R.drawable.ic_avatar_placeholder)
//                .circleCrop()
//
//    }

    private val name: TextView = itemView.findViewById(R.id.tv_actor_name)
    private val image: ImageView = itemView.findViewById(R.id.iv_actor_foto)


    fun onBind(actor: Actor){
        name.text = actor.name
        image.setImageResource(actor.avatar)

    }
}
private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

//interface OnRecyclerItemClicked {
//    fun onClick(moviePosition: Int)
//}