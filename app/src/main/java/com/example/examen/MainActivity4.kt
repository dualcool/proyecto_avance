package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val imgResult: ImageView = findViewById(R.id.img_result)
        val btnAciertos: TextView = findViewById(R.id.btn_aciertos)
        val btnErrores: TextView = findViewById(R.id.btn_errores)
        val btnHome: Button = findViewById(R.id.btn_home)  // Botón para regresar al inicio

        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)

        btnAciertos.text = "Aciertos: $correctAnswers"
        btnErrores.text = "Errores: $incorrectAnswers"
        imgResult.setImageResource(R.drawable.fin_juego)



        // Acción para el botón de regreso al inicio
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Usar finishAffinity() para cerrar todas las actividades anteriores
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finishAffinity()  // Esto asegura que todas las actividades previas se cierren
        }
    }
}
