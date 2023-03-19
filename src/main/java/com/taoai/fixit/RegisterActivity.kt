package com.taoai.fixit

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.text.InputType
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.UserProfileChangeRequest
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var signInLauncher: ActivityResultLauncher<Intent>

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        supportActionBar?.hide()
        window.statusBarColor = resources.getColor(R.color.welnav)

        val loginTextButton = findViewById<TextView>(R.id.loginTextButton)
        loginTextButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
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
                Log.w(ContentValues.TAG, "signInResult:failed code=" + e.statusCode)
                handleSignInResult(null)
            }
        }

        val passwordEditText: EditText = findViewById(R.id.passBarRegister)
        val passwordVisibilityImageView: ImageView = findViewById(R.id.passButtRegister)

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

        auth = FirebaseAuth.getInstance()

        val firstNameEditText: EditText = findViewById(R.id.firstName)
        val lastNameEditText: EditText = findViewById(R.id.lastName)
        val emailRegEditText: EditText = findViewById(R.id.emailReg)
        val passBarRegisterEditText: EditText = findViewById(R.id.passBarRegister)
        val registerButton: Button = findViewById(R.id.regButton)

        registerButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val email = emailRegEditText.text.toString()
            val password = passBarRegisterEditText.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                if (firstName.isEmpty()) {
                    firstNameEditText.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    firstNameEditText.setBackgroundResource(R.drawable.input_bar_background)
                }
                if (lastName.isEmpty()) {
                    lastNameEditText.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    lastNameEditText.setBackgroundResource(R.drawable.input_bar_background)
                }
                if (email.isEmpty()) {
                    emailRegEditText.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    emailRegEditText.setBackgroundResource(R.drawable.input_bar_background)
                }
                if (password.isEmpty()) {
                    passBarRegisterEditText.setBackgroundResource(R.drawable.input_bar_background_empty)
                } else {
                    passBarRegisterEditText.setBackgroundResource(R.drawable.input_bar_background)
                }
                MotionToast.darkToast(this,
                    "Warning",
                    "Please fill are required fields",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(this,R.font.baloo))
            } else {
                registerUser(firstName, lastName, email, password)
            }
        }
    }
    private fun registerUser(firstName: String, lastName: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration success, update user profile with firstName and lastName
                    val user = auth.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName("$firstName $lastName")
                        .build()

                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val intent = Intent(this, MainActivity::class.java)
                                MotionToast.darkToast(this,
                                    "Hurray success 😍",
                                    "Registered successfully!",
                                    MotionToastStyle.SUCCESS,
                                    MotionToast.GRAVITY_BOTTOM,
                                    MotionToast.SHORT_DURATION,
                                    ResourcesCompat.getFont(this,R.font.baloo))
                                startActivity(intent)
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
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
    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }

    private fun handleSignInResult(account: GoogleSignInAccount?) {
        if (account != null) {
            val intent = Intent(this, MainActivity::class.java)
            MotionToast.darkToast(this,
                "Hurray success 😍",
                "Registered successfully!",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this,R.font.baloo))
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
