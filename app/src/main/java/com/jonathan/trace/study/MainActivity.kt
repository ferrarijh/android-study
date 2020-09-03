package com.jonathan.trace.study

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        var id = intent.getStringExtra("userId")
        Log.d("myid","${id.toString()}!")
        id = "Welcome, $id!"
        welcomeText.text = id

        val sp = getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("id", id)
        editor.apply()
    }
}