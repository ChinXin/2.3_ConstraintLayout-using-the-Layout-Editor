package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvBoxOne   : TextView
    lateinit var tvBoxTwo   : TextView
    lateinit var tvBoxThree : TextView
    lateinit var tvBoxFour  : TextView
    lateinit var tvBoxFive  : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvBoxOne = findViewById(R.id.box_one_text)
        tvBoxTwo = findViewById(R.id.box_two_text)
        tvBoxThree = findViewById(R.id.box_three_text)
        tvBoxFour = findViewById(R.id.box_four_text)
        tvBoxFive = findViewById(R.id.box_five_text)

        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            R.id.red_button -> tvBoxThree.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> tvBoxFour.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> tvBoxFive.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val redBtn : Button = findViewById(R.id.red_button)
        val greenBtn : Button = findViewById(R.id.green_button)
        val yellowBtn : Button = findViewById(R.id.yellow_button)

        val rootConstraintLayout : View = findViewById(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(tvBoxOne, tvBoxTwo, tvBoxThree,
                tvBoxFour, tvBoxFive, rootConstraintLayout,
                redBtn, greenBtn, yellowBtn)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}