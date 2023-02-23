package com.example.myappsem6

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Feb20JobScheduler : AppCompatActivity() {
    var jobScheduler: JobScheduler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb20_job_scheduler)

        val stopJob = findViewById<Button>(R.id.stopJobBtn)
        val startJob = findViewById<Button>(R.id.startJobBtn)
        startJob.setOnClickListener {
            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE)
                    as JobScheduler
            val componentName = ComponentName(this,
                Feb20JobScheduler2::class.java)
            val builder = JobInfo.Builder(123, componentName)
            builder.setMinimumLatency(8000)
            builder.setOverrideDeadline(10000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }
        stopJob.setOnClickListener {
            if (jobScheduler != null) {
                jobScheduler!!.cancel(123)
                jobScheduler = null
                Toast.makeText(this, "Job Cancelled",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}