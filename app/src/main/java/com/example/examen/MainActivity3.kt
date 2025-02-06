package com.example.examen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var textQuestion: TextView
    private lateinit var textResult: TextView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var btnRegresar: Button
    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    // Lista de preguntas con sus imágenes y respuestas correctas
    private val questions = listOf(
        Question("¿Cuál de estas imágenes es un caballo?", R.drawable.perro, R.drawable.caballo, R.drawable.gato, R.drawable.gallo, 2),
        Question("¿Cuál de estos es un avión?", R.drawable.barco, R.drawable.coche, R.drawable.avion, R.drawable.tren, 3),
        Question("¿Cuál de estos es un árbol?", R.drawable.flor, R.drawable.arbol, R.drawable.montana, R.drawable.rio, 2),
        Question("¿Cuál de estos es una manzana?", R.drawable.platano, R.drawable.uva, R.drawable.manzana, R.drawable.naranja, 3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        textQuestion = findViewById(R.id.text_question)
        textResult = findViewById(R.id.text_result)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        btnRegresar = findViewById(R.id.btn_regresar)

        loadQuestion()

        img1.setOnClickListener { checkAnswer(1) }
        img2.setOnClickListener { checkAnswer(2) }
        img3.setOnClickListener { checkAnswer(3) }
        img4.setOnClickListener { checkAnswer(4) }

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        textQuestion.text = question.question
        img1.setImageResource(question.image1)
        img2.setImageResource(question.image2)
        img3.setImageResource(question.image3)
        img4.setImageResource(question.image4)
        textResult.text = ""
    }

    private fun checkAnswer(selectedOption: Int) {
        val question = questions[currentQuestionIndex]
        if (selectedOption == question.correctAnswer) {
            textResult.text = "¡Correcto! 🎉"
            textResult.setTextColor(Color.GREEN)
            correctAnswers++
        } else {
            textResult.text = "❌ Incorrecto."
            textResult.setTextColor(Color.RED)
            incorrectAnswers++
        }

        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            textResult.postDelayed({ loadQuestion() }, 1000)
        } else {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            intent.putExtra("incorrectAnswers", incorrectAnswers)
            startActivity(intent)
            finish()
        }
    }
}

// Clase de datos para almacenar las preguntas
data class Question(
    val question: String,
    val image1: Int,
    val image2: Int,
    val image3: Int,
    val image4: Int,
    val correctAnswer: Int
)

