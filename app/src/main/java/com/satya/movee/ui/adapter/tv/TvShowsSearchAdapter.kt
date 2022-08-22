package com.satya.movee.ui.adapter.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.satya.movee.R
import com.satya.movee.constants.Constant
import com.satya.movee.databinding.MovieRvSearchBinding
import com.satya.movee.ui.adapter.SearchAdapter

class TvShowsSearchAdapter : RecyclerView.Adapter<TvShowsSearchAdapter.ViewHolder>() {

    private var movies = mutableListOf<com.satya.movee.model.search.tv.Result?>()

    fun setSearchData(movies: List<com.satya.movee.model.search.tv.Result?>?) {
        this.movies = movies!!.toMutableList()
        this.notifyDataSetChanged()

    }
    class ViewHolder(val binding: MovieRvSearchBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieRvSearchBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var posterPath = ""
        var name = ""

        val movie = movies[position]

        Glide.with(holder.itemView.context)
            .load(Constant.imageBaseUrl + movie?.posterPath)
            .placeholder(R.drawable.logo)
            .into(holder.binding.moviePoster)

        holder.binding.movieName.text = movie?.name
        "${movie?.voteAverage} / 10".also { holder.binding.rating.text = it }

    }

    override fun getItemCount(): Int {
        if(movies.size <= 10) {
            return movies.size
        } else {
            return movies.size / 2
        }
    }

}