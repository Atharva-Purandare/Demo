package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {
	
	var currentIndex = 0
	var isCheater = false
	
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
	val currentQuestionAnswer: Boolean
		get() = questionBank[currentIndex].answer
	val currentQuestionText: Int
		get() = questionBank[currentIndex].textResId
	fun moveToNext() {
		currentIndex = (currentIndex + 1) % questionBank.size
	}
	
	
}