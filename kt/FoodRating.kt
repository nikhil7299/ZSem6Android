package com.example.myappsem6

import android.media.Rating
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class FoodRating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_rating)

        val qualityRating :RatingBar = findViewById(R.id.quality)
        val quantityRating: RatingBar = findViewById(R.id.quantity)
        val easeRating:RatingBar = findViewById(R.id.ease)
        val deliveryRating:RatingBar = findViewById(R.id.delivery)

        var overallRating:RatingBar = findViewById(R.id.overall)
        val submitRating : Button = findViewById(R.id.submitRating)
        val realTimeRating :RatingBar = findViewById(R.id.overallRealTime)


        submitRating.setOnClickListener{
            val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
            val overallR = totalOverall/4

            overallRating.rating=overallR
            Toast.makeText(this@FoodRating,"$overallR",Toast.LENGTH_LONG).show()
        }
        overallRating.onRatingBarChangeListener= RatingBar.OnRatingBarChangeListener{
            ratingBar, overallR, fromUser ->  Toast.makeText(
            this@FoodRating,
            "ratingBar: $ratingBar \n rating:$overallR fromUser: $fromUser",
            Toast.LENGTH_LONG
        ).show()
        }

        qualityRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
            ratingBar, qualityR, fromUser ->
                Toast.makeText(
                    this@FoodRating,
                    "ratingBar: $ratingBar\n rating:$qualityR fromUser: $fromUser",
                    Toast.LENGTH_LONG
                ).show()
            val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
            val overallR = totalOverall/4
            realTimeRating.rating = overallR
        }
        quantityRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
                ratingBar, quantityR, fromUser ->
            Toast.makeText(
                this@FoodRating,
                "ratingBar: $ratingBar\n rating:$quantityR fromUser: $fromUser",
                Toast.LENGTH_LONG
            ).show()
            val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
            val overallR = totalOverall/4
            realTimeRating.rating = overallR
        }
        easeRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
                ratingBar, easeR, fromUser ->
            Toast.makeText(
                this@FoodRating,
                "ratingBar: $ratingBar\n rating:$easeR fromUser: $fromUser",
                Toast.LENGTH_LONG
            ).show()
            val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
            val overallR = totalOverall/4
            realTimeRating.rating = overallR
        }
        deliveryRating.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{
                ratingBar, deliveryR, fromUser ->
            Toast.makeText(
                this@FoodRating,
                "ratingBar: $ratingBar\n rating:$deliveryR fromUser: $fromUser",
                Toast.LENGTH_LONG
            ).show()
            val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
            val overallR = totalOverall/4
            realTimeRating.rating = overallR
        }

//        realTimeRating.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                val totalOverall = qualityRating.rating + quantityRating.rating+easeRating.rating+deliveryRating.rating
//                val overallR = totalOverall/4
//                realTimeRating.rating = overallR
//                return true
//            }
//        })


    }

    override fun onBackPressed() {
     //   super.onBackPressed()
        val customAlertRating = LayoutInflater.from(this).inflate(R.layout.activity_custom_alert_rating_bar, null)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("My Alert Dialog")
            .setMessage("Do you want to exit?")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setCancelable(true)
            .setView(customAlertRating)
            .setNeutralButton("Cancel"){dialogInterface,which->
                Toast.makeText(this,"Cancel Clicked",Toast.LENGTH_LONG).show()

            }
            .setNegativeButton("No"){dialogInterface,which->
                Toast.makeText(this,"No Clicked",Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Yes"){dialogInterface,which->
                Toast.makeText(this,"Yes Clicked",Toast.LENGTH_LONG).show()
                super.onBackPressed()

            }
            .show()
    }
}

