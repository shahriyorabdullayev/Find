package com.shza.cleanarch2.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import com.shza.cleanarch2.R
import com.shza.cleanarch2.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAnimation()
        timer()
    }

    private fun setupAnimation() {
        val animation1 = AnimationUtils.loadAnimation(applicationContext, R.anim.move)
        val animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.move2)
        val animation3 = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        with(binding) {
            ivQuestion.startAnimation(animation1)
            ivQuestion.startAnimation(animation3)
            ivChild.startAnimation(animation2)
            //tvTitle.startAnimation(animation3)
        }
    }

    private fun timer() {
        val timer = object : CountDownTimer(2500, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() { callMainActivity() }
        }
        timer.start()
    }

    private fun callMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}