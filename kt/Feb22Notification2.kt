package com.example.myappsem6

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Feb22Notification2 : AppCompatActivity() {
    lateinit var notificatonTxtView :TextView
    lateinit var notificationManager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb22_notification2)
        notificatonTxtView = findViewById(R.id.notificationTxtView)
        var inp = Feb22Notification()
        notificatonTxtView.text="Your Notification"
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(inp.notificationId)
    }
}