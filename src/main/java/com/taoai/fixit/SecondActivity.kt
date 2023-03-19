package com.taoai.fixit

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        supportActionBar?.hide()
        window.statusBarColor = resources.getColor(R.color.welnav)

        val buttonNext = findViewById<Button>(R.id.buttonNext)
        val imageView = findViewById<ImageView>(R.id.BussMan)

        val animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1500
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }

        animator.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Float
            imageView.translationY = animatedValue * 50
        }

        animator.start()

        buttonNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }
}
