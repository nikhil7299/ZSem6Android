package com.example.myappsem6

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Feb15RepeatAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb15_repeat_alarm)

        var start = findViewById<Button>(R.id.setBtn)
        var repeat = findViewById<Button>(R.id.repBtn)
        var et = findViewById<EditText>(R.id.repeatAlarmET)
        var cancleAlarm =findViewById<Button>(R.id.cancleBtn)


        var alarmManager:AlarmManager
        val i =Intent(this,MyRepeatAlarm::class.java)

        val pendingIntent = PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_IMMUTABLE)

        start.setOnClickListener{
            var l = et.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (l*1000),pendingIntent)
            Toast.makeText(this,"Alarm Set",Toast.LENGTH_LONG).show()
        }
        repeat.setOnClickListener{
            var l = et.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (l*1000),60000,pendingIntent)

        }

        cancleAlarm.setOnClickListener {
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this,"Alarm Cancelled",Toast.LENGTH_LONG).show()

        }


    }
    class MyRepeatAlarm: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var mp = MediaPlayer.create(p0, R.raw.alarm)

            Log.d("Hello","repeating alarm")
            mp.start()
            Toast.makeText(p0,"Alarm is Ringing",Toast.LENGTH_LONG).show()
        }
    }

}
