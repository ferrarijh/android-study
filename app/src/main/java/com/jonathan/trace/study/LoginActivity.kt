package com.jonathan.trace.study

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private val REG_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_const)

        val idText = findViewById<TextView>(R.id.idText)
        val pwText = findViewById<TextView>(R.id.pwText)

        val sp = getSharedPreferences("user", Activity.MODE_PRIVATE)
        val id = sp.getString("id","")
        if (id != ""){
            val intent = Intent(this, MainActivity::class.java)
                .putExtra("userId", id)
            startActivity(intent)
        }else
            Toast.makeText(this, "sf id field is empty", Toast.LENGTH_SHORT).show()

        val loginBtn = findViewById<Button>(R.id.loginButton).setOnClickListener{
            if(idText.text.isNullOrBlank() || pwText.text.isNullOrBlank()){
                Toast.makeText(this, "Invalid id/password input.", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                    .putExtra("userId", idText.text.toString())
                startActivity(intent)
            }
        }
        val registerText = findViewById<TextView>(R.id.registerText).setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, REG_REQUEST_CODE)
        }
    }

    override fun onActivityResult(reqCode: Int, resCode: Int, data: Intent?){
        super.onActivityResult(reqCode, resCode, data)
        if (resCode != RESULT_OK){
            val text = "Something went wrong :(" +
                    "\nid: ${data?.extras?.getString("userId")}" +
                    "\npw: ${data?.extras?.getString("userPw")}"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        when(reqCode){
            REG_REQUEST_CODE -> {
                val idText = findViewById<TextView>(R.id.idText)
                val pwText = findViewById<TextView>(R.id.pwText)
                idText.text = data?.extras?.getString("userId")
                pwText.text = data?.extras?.getString("userPw")
            }
        }
    }
}