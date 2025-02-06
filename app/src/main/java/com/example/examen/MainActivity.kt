package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInstrucciones: Button = findViewById(R.id.btn_instrucciones)


        // Evento de clic para ir a MainActivity2 (Instrucciones)
        btnInstrucciones.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val btnJugar: Button = findViewById(R.id.btn_jugar)

        // Evento de clic para ir a MainActivity3 (Juego)
        btnJugar.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}
