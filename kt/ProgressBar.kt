package com.example.myappsem6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.ProgressBar

class ProgressBar : AppCompatActivity() {
    private var i =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        val pgsBar = findViewById<ProgressBar>(R.id.pBar)
        val pgsBar1 = findViewById<ProgressBar>(R.id.pBarCircular)
        val txtView = findViewById<TextView>(R.id.tView)
        val btn: Button = findViewById(R.id.btnShow)
        val btn1: Button = findViewById(R.id.btnReset)
        pgsBar1.visibility = View.INVISIBLE
        btn.setOnClickListener{
            pgsBar1.visibility = View.VISIBLE
            i = pgsBar.progress
            Thread {
                while (i < 100) {
                    i += 1
                    // Update the progress bar and display the current value in text view
                    Handler(Looper.getMainLooper()).post {
                        // Your Code
                        pgsBar.progress = i
                        txtView.text = i.toString() + "/" + pgsBar.max
                        if (i == 100) {
                            pgsBar1.visibility = View.INVISIBLE
                        }
                    }
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        }
        btn1.setOnClickListener {
            pgsBar.progress = 0
            txtView.text = 0.toString() + "/" + pgsBar.max
        }
    }
}