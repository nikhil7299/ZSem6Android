package com.example.myappsem6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class Feb2ToolBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feb2_tool_bar)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle("ToolBar Example")
        toolbar.setLogo(R.drawable.ic_baseline_dehaze_24)
        setSupportActionBar(toolbar) //replace toolbar as an ActionBar
        toolbar.setNavigationOnClickListener{
            Toast.makeText(this, "Back Arrow",
                Toast.LENGTH_LONG).show()
        } }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menufeb2, menu)
        return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id:Int = item.itemId
//        if(id==R.id.action_settings)
//        {
//            Toast.makeText(applicationContext, "Settings Menu", Toast.LENGTH_LONG).show()
//            return true
//        }
//        else if(id == R.id.action_email)
//        {
//            Toast.makeText(applicationContext, "Email", Toast.LENGTH_LONG).show()
//            return true
//        }
//        else if (id == R.id.action_add)
//        {
//            Toast.makeText(applicationContext, "Add", Toast.LENGTH_LONG).show()
//            return true
//        }
//        return super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "Settings Menu", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_email -> {
                Toast.makeText(applicationContext, "Email", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_add -> {
                Toast.makeText(applicationContext, "Add", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
