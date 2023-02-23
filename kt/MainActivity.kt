package com.example.myappsem6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleRatingBar: RatingBar = findViewById(R.id.simpleRatingBar)
        val simpleRating = findViewById<RatingBar>(R.id.simpleRating)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener(){
            val totalStars ="Total Stars:: ${simpleRatingBar.numStars}"
            val rating = "Rating :: ${simpleRating.rating}"
            Toast.makeText(this@MainActivity,"""$totalStars $rating""".trimIndent(),Toast.LENGTH_LONG).show()
        }
        simpleRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener {
            ratingBar, rating, fromUser ->
            Toast.makeText(this@MainActivity,"rating$rating",Toast.LENGTH_LONG).show()
        }
    }
}