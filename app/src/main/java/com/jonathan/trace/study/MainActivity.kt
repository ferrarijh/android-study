package com.jonathan.trace.study

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val id = intent.getStringExtra("userId")
        Log.d("myid","$id!")
        val welcome = "Welcome, $id!"
        welcomeText.text = welcome

        val sp = getSharedPreferences("user", Activity.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("id", id)
        editor.apply()
    }
}