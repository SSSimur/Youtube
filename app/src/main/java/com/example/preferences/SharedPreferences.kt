package com.example.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.util.utils
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import javax.crypto.SecretKey

public class SharedPreferences(context: Context) {

    private var prefs = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)



    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString("token", null)
    }

    fun getEmail(): String? {
        return prefs.getString("email", null)
    }

    fun getId(): String? {
        return prefs.getString("id", null)
    }

    fun removeToken() {
        val editor = prefs.edit()
        editor.remove("token")
        editor.remove("email")
        editor.remove("id")
        editor.apply()
    }

    public fun recieveToken(token: String) {
        val secretKey: SecretKey = Keys.hmacShaKeyFor(utils.SECRET_KEY.toByteArray())
        val jws = Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token!!.split(" ")[1].trim())
        val body = jws.body
        val email = body["email"].toString()
        val id = body["id"].toString()
        val editor = prefs.edit()
        editor.putString("token", token)
        editor.putString("email", email)
        editor.putString("id", id)
        editor.apply()
    }


}