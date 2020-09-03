package com.jonathan.trace.study

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RegisterActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<TextView>(R.id.registerSubmitButton).setOnClickListener{
            val userId = findViewById<EditText>(R.id.registerIdEdit).text.toString()
            val userPw = findViewById<EditText>(R.id.registerPwEdit).text.toString()
            val userName = findViewById<EditText>(R.id.registerNameEdit).text.toString()
            val userAge = findViewById<EditText>(R.id.registerAgeEdit).text.toString().toInt()  //입력값 int 아니면 NumberFormatException

            //val sf = getSharedPreferences("user", Context.MODE_PRIVATE)
            val intent = Intent()
            intent.putExtra("userId", userId)
            intent.putExtra("userPw", userPw)
            setResult(RESULT_OK, intent)
            finish()
            /*---in dev----
            val responseListener = Response.Listener<String>{
                try{
                    val jsonObject = JSONObject(it)
                    val isSuccess = jsonObject.getBoolean("success")
                    val builder = AlertDialog.Builder(this)
                    if(isSuccess) {
                        builder.setMessage("Successfully registered!")
                            .setPositiveButton("OK", null)
                            .create()
                            .show()
                        startActivity(Intent(this, LoginActivity::class.java))
                    }else{
                        builder.setMessage("Register failed. Please try again.")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show()
                    }
                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
            val registerRequest = RegisterRequest(userId, userPw, userName, userAge, responseListener)
            val q = Volley.newRequestQueue(this)
            q.add(registerRequest)

             */
        }
    }
}