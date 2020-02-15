package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun poexali(view: View){
        val mainWi = Intent(this, Main2Activity::class.java)
        startActivity(mainWi)

    }
}
