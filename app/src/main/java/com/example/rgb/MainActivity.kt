package com.example.rgb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var bt1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.bt1 = findViewById(R.id.bt1)
        this.bt1.setOnClickListener{
            val intent: Intent = Intent(this, ReceiverScreen::class.java)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "12, 205, 125")
            startActivity(intent)
        }
    }
}