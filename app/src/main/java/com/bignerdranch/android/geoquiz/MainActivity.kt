package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
	private lateinit var trueButton: Button
	private lateinit var falseButton: Button
	private lateinit var nextButton: Button
	private lateinit var questionTextView: TextView
	private val questionBank = listOf(
		Question(R.string.question_1, false),
		Question(R.string.question_2, false),
		Question(R.string.question_3, true),
		Question(R.string.question_4, false),
		Question(R.string.question_5, true),
		Question(R.string.question_6, true),
		Question(R.string.question_7, true),
		Question(R.string.question_8, true),
		Question(R.string.question_9, false),
		Question(R.string.question_10, false))
		
	
	private var currentIndex = 0
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		trueButton = findViewById(R.id.true_button)
		falseButton = findViewById(R.id.false_button)
		nextButton = findViewById(R.id.next_button)
		questionTextView = findViewById(R.id.question_text_view)
		
		trueButton.setOnClickListener { view: View ->
			val btn: Button = (view as Button)
			checkAnswer(true)
		}
		falseButton.setOnClickListener { view: View ->
			val btn: Button = (view as Button)
			checkAnswer(false)
			
			
		}
		nextButton.setOnClickListener {
			currentIndex = (currentIndex + 1) % questionBank.size
			updateQuestion()
			
		}
		updateQuestion()
		
	}

private fun updateQuestion() {
	val questionTextResId = questionBank[currentIndex].textResId
	questionTextView.setText(questionTextResId)
}
	private fun checkAnswer(userAnswer: Boolean) {
		val correctAnswer = questionBank[currentIndex].answer
		
		val messageResId = if (userAnswer == correctAnswer) {
			R.string.correct_toast
		} else {
			R.string.incorrect_toast
		}
		
		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
			.show()
	}
	

}