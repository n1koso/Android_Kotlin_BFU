package com.example.clicker

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var strength:Int = 0
    private var score:Int = 0
    private var count:Int = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scoreText: TextView = findViewById(R.id.scoreText)
        val counterText: TextView = findViewById(R.id.countText)
        val mulText: TextView = findViewById(R.id.mulText)
        val btnPushMe: Button = findViewById(R.id.pushMe)
        val parrot2: ImageView =  findViewById(R.id.Parrot2)

        btnPushMe.setOnClickListener {
            if(count%10 == 0) {
                strength++
            }

            count++
            score += strength

            if(count%10 ==0) {
                parrot2.visibility = View.VISIBLE
            } else {
                parrot2.visibility = View.INVISIBLE
            }

            scoreText.text = score.toString()
            counterText.text = count.toString()
            mulText.text = strength.toString()
        }
    }
}