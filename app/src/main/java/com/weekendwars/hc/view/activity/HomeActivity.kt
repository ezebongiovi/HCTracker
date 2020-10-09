package com.weekendwars.hc.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weekendwars.hc.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button.setOnClickListener {
            button.text = (Integer.valueOf(button.text.toString()) + 1).toString()
        }
    }
}