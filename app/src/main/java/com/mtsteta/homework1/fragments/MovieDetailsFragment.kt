package com.mtsteta.homework1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.mtsteta.homework1.R
import com.mtsteta.homework1.dto.MovieDto

private const val MOVIE_NAME = "movieName"
private const val MOVIE_DESCRIPTION = "movieDescription"
private const val MOVIE_STAR_NUMBER = "movieStarNumber"
private const val MOVIE_AGE = "movieAge"
private const val MOVIE_IMAGE_URL = "movieImageUrl"

class MovieDetailsFragment : Fragment() {
    private var movieName: String? = null
    private var movieDescription: String? = null
    private var movieStarNumber: Int? = null
    private var movieAge: Int? = null
    private var movieImageUrl: String? = null

    private lateinit var moviePoster: ImageView
    private lateinit var movieNameTextView: TextView
    private lateinit var movieDescriptionTextView: TextView
    private lateinit var movieAgeTextView: TextView
    private lateinit var movieRatingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieName = it.getString(MOVIE_NAME)
            movieDescription = it.getString(MOVIE_DESCRIPTION)
            movieStarNumber = it.getInt(MOVIE_STAR_NUMBER)
            movieAge = it.getInt(MOVIE_AGE)
            movieImageUrl = it.getString(MOVIE_IMAGE_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviePoster = view.findViewById(R.id.movie_details_film_poster)
        movieNameTextView = view.findViewById(R.id.movie_details_name)
        movieDescriptionTextView = view.findViewById(R.id.movie_details_film_description)
        movieAgeTextView = view.findViewById(R.id.movie_details_age_limit)
        movieRatingBar = view.findViewById(R.id.movie_details_rating_bar)

        moviePoster.load(movieImageUrl)
        movieNameTextView.text = movieName
        movieDescriptionTextView.text = movieDescription
        movieAgeTextView.text = movieAge.toString() + "+"
        movieRatingBar.rating = movieStarNumber!!.toFloat()
    }

    companion object {
        @JvmStatic
        fun newInstance(movie: MovieDto) =
            MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_NAME, movie.title)
                    putString(MOVIE_DESCRIPTION, movie.description)
                    putInt(MOVIE_STAR_NUMBER, movie.rateScore)
                    putInt(MOVIE_AGE, movie.ageRestriction)
                    putString(MOVIE_IMAGE_URL, movie.imageUrl)
                }
            }
    }
}