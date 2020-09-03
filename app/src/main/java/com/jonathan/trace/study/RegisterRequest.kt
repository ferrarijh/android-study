package com.jonathan.trace.study

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class RegisterRequest(
    userId: String,
    userPw: String,
    userName: String,
    userAge: Int,
    listener: Response.Listener<String>
) : StringRequest(Method.POST, URL, listener, null) {

    companion object{
        val URL = ""
    }

    private val parameters : Map<String, String>
    init{
        val test = userId
        parameters = mutableMapOf<String, String>()
        parameters["userId"] = userId
        parameters["userPassword"] = userPw
        parameters["userName"] = userName
        parameters["userAge"] = "$userAge"
    }

    override fun getParams() = parameters
}