package com.xrubio.securecontrols.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.xrubio.securecontrols.SecureButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secureButton = findViewById<SecureButton>(R.id.secure_button)
        secureButton.windowObscuredTouchEvent = { _, _ ->
            Toast.makeText(this, "Screen overlay detected", Toast.LENGTH_LONG).show()
            false
        }
        secureButton.setOnClickListener {
            Toast.makeText(this, "Click succeeded!", Toast.LENGTH_LONG).show()
        }
    }

}
