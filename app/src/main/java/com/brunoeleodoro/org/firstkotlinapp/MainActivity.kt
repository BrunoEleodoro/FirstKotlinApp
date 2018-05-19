package com.brunoeleodoro.org.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.RequestQueue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun teste()
    {
        Toast.makeText(this,"teste",Toast.LENGTH_SHORT).show()

        RequestQueue queu
    }
}
