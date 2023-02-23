package com.example.myappsem6

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.getSystemService

class Feb22Notification : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    val channelId = "My Channel"
    val notificationId = 1234
    val title = "Notification"
    val description = "Test My Notification"
    lateinit var notificationBtn:Button
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb22_notification)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationBtn = findViewById(R.id.notificationBtn)

        notificationBtn.setOnClickListener {
            val intent = Intent(this,Feb22Notification2::class.java)
            pendingIntent = PendingIntent.getActivity(
                this,0,intent,PendingIntent.FLAG_IMMUTABLE
            )
            createYourChannel()
            notificationManager.notify(notificationId,builder.build())
        }
    }
    fun createYourChannel (){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.lightColor =Color.GREEN
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_baseline_circle_notifications_24))
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
        else{
            builder = Notification.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_baseline_notifications_24))
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }
}