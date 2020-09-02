package com.jonathan.trace.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_const)

        val idText = findViewById<TextView>(R.id.idText)
        val pwText = findViewById<TextView>(R.id.pwText)
        val loginBtn = findViewById<Button>(R.id.loginButton).setOnClickListener{
            if(idText.text.isNullOrBlank() || pwText.text.isNullOrBlank()){
                Toast.makeText(this, "Invalid id/password input.", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        val registerText = findViewById<TextView>(R.id.registerText).setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

/*
setOnClickListener(View.onClickListener{
    override fun onClick
})

 */