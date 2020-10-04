package com.example.rgb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReceiverScreen : AppCompatActivity() {
    private lateinit var tv1 : TextView
    private lateinit var tv2 : TextView
    private lateinit var tv3 : TextView

    private lateinit var telaB: telabloqueadaReceiver
    private lateinit var intentF : IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_screen)

        this.tv1 = findViewById(R.id.tv1)
        this.tv2 = findViewById(R.id.tv2)
        this.tv3 = findViewById(R.id.tv3)

        this.telaB = telabloqueadaReceiver()
        this.intentF = IntentFilter()
        this.intentF.addAction(Intent.ACTION_SCREEN_ON)
        this.intentF.addAction(Intent.ACTION_SCREEN_OFF)

        val cor = intent.getStringExtra(Intent.EXTRA_TEXT)

        if(cor != null){
            val tonalidades = cor.split(", ")
            this.tv1.setText(tonalidades[0])
            this.tv1.setBackgroundColor(Color.rgb(tonalidades[0].toInt(),0,0))
            this.tv2.setText(tonalidades[1])
            this.tv2.setBackgroundColor(Color.rgb(0,tonalidades[1].toInt(),0))
            this.tv3.setText(tonalidades[2])
            this.tv3.setBackgroundColor(Color.rgb(0,0,tonalidades[2].toInt()))
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(this.telaB, this.intentF)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(this.telaB)
    }

    inner class telabloqueadaReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            this@ReceiverScreen.tv1.text = "Tonalidade Vermelha"
            this@ReceiverScreen.tv2.text = "Tonalidade Verde"
            this@ReceiverScreen.tv3.text = "Tonalidade Azul"
        }
    }
}