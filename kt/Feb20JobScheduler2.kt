package com.example.myappsem6

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log

class Feb20JobScheduler2 :JobService(){

    override fun onStartJob(p0: JobParameters?): Boolean {
        val intent = Intent(this,Feb15RepeatAlarm.MyRepeatAlarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,23,intent,PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingIntent)
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("Job","Stopped")
        return true

    }

}