package com.taoai.fixit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val splashScreenDuration: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        val currentUser = FirebaseAuth.getInstance().currentUser

        Handler(Looper.getMainLooper()).postDelayed({
            if (currentUser != null) {
                // User is signed in, open UserActivity
                val intent = Intent(this, UserMainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                if (account != null) {
                    // User is logged in, open UserActivity
                    val intent = Intent(this, UserMainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        }, splashScreenDuration)
    }
}