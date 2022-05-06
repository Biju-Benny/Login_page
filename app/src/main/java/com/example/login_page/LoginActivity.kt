package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userInputEditText.doOnTextChanged { text, start, before, count ->

            userInputLayout.error = null
        }
        passwordInputEditText.doOnTextChanged { text, start, before, count ->

            passwordInputLayout.error = null
        }

        btnLogin.setOnClickListener {

            val userName = userInputEditText.text
            val pass = passwordInputEditText.text
            if(userName.toString() != "userOne" && pass.toString() != "Pass1234"){
                userInputLayout.error = "Wrong User Name"
                passwordInputLayout.error = "Wrong Password"

            } else if(userName.toString() != "userOne") {
                userInputLayout.error = "Wrong User Name"
                if (pass.toString() != "Pass1234") {

                    passwordInputLayout.error = "Wrong Password"
                }
            }else if (pass.toString() != "Pass1234") {

                    passwordInputLayout.error = "Wrong Password"

                }

            else{
                startActivity(Intent(this,LoadingActivity::class.java))

            }
        }
    }

    override fun onResume() {
        super.onResume()
        userInputEditText.text = null
        passwordInputEditText.text = null
    }


}