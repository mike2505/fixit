package com.taoai.fixit

import android.content.ContentValues.TAG
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.res.ResourcesCompat
import com.google.firebase.auth.FirebaseAuth
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


@Suppress("NAME_SHADOWING")
class LoginActivity : AppCompatActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var signInLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        supportActionBar?.hide()
        window.statusBarColor = resources.getColor(R.color.welnav)

        val loginTextButton = findViewById<TextView>(R.id.loginTextButton)
        loginTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val emailReg: EditText = findViewById(R.id.emailReg)
        val passwordEditText: EditText = findViewById(R.id.passBar)
        val passwordVisibilityImageView: ImageView = findViewById(R.id.passhide)
        val regButton = findViewById<Button>(R.id.regButton)

        regButton.setOnClickListener {
            val email = emailReg.text.toString()
            val pass = passwordEditText.text.toString()
            if (email.isEmpty() || pass.isEmpty()) {1
                if (email.isEmpty()) {
                    emailReg.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    emailReg.setBackgroundResource(R.drawable.input_bar_background)
                }
                if (pass.isEmpty()) {
                    passwordEditText.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    passwordEditText.setBackgroundResource(R.drawable.input_bar_background)
                }
                MotionToast.darkToast(this,
                    "Warning",
                    "Please fill are required fields",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(this,R.font.baloo))
            } else {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            MotionToast.darkToast(this,
                                "Hurray success 😍",
                                "Login successfully!",
                                MotionToastStyle.SUCCESS,
                                MotionToast.GRAVITY_BOTTOM,
                                MotionToast.SHORT_DURATION,
                                ResourcesCompat.getFont(this,R.font.baloo))
                            startActivity(intent)
                        } else {
                            MotionToast.darkToast(this,
                                "Failed️",
                                "${task.exception?.message}",
                                MotionToastStyle.ERROR,
                                MotionToast.GRAVITY_BOTTOM,
                                MotionToast.LONG_DURATION,
                                ResourcesCompat.getFont(this,R.font.baloo))
                        }
                    }
            }
        }

        passwordVisibilityImageView.setOnClickListener {
            if (passwordEditText.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                // Show password
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                passwordVisibilityImageView.setImageResource(R.drawable.sign_up_group_7336)
                passwordEditText.hint = ""
            } else {
                // Hide password
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                passwordVisibilityImageView.setImageResource(R.drawable.sign_up_group_7335)
            }
            // Move cursor to the end of the text
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Set a click listener on the Google Login button
        findViewById<Button>(R.id.googleLogin).setOnClickListener {
            signInWithGoogle()
        }

        signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                handleSignInResult(account)
            } catch (e: ApiException) {
                Log.w(TAG, "signInResult:failed code=" + e.statusCode)
                handleSignInResult(null)
            }
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }

    private fun handleSignInResult(account: GoogleSignInAccount?) {
        if (account != null) {
            MotionToast.darkToast(this,
                "Hurray success 😍",
                "Registered successfully!",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this,R.font.baloo))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        } else {
            MotionToast.darkToast(this,
                "Failed️",
                "Hm.. Check your internet connection",
                MotionToastStyle.ERROR,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.baloo))
        }
    }
}
