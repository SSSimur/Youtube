package com.example.youtube

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Carousel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)

    }




    fun regButton(view: View) {
        val car1 = findViewById<ImageView>(R.id.car3)
        val car2 = findViewById<ImageView>(R.id.car2)
        val car3 = findViewById<ImageView>(R.id.car1)
        val but1 = findViewById<Button>(R.id.button)
        val start_but = findViewById<Button>(R.id.start)
        car1.animate().alpha(0F).translationXBy(-1000F)!!.setDuration(500)
        if (car1.alpha == 0F) {
            car2.animate().alpha(0F).translationXBy(-1000F)!!.setDuration(500)
            car1.animate().alpha(1F).translationXBy(-1000F)!!.setDuration(500)
        } else if (car2.alpha == 0F) {
            but1.animate().alpha(0F).setDuration(0)
            but1.animate().translationXBy(-1000F)!!.setDuration(0)
            start_but.animate().alpha(1F).translationYBy(-100F)!!.setDuration(100)


        }
    }

    fun start_button(view: View) {
        val nextPage = Intent(this, Login::class.java)
        startActivity(nextPage)
        finish()
    }
}