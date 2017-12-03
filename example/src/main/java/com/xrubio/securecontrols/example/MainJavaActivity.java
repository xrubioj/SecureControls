package com.xrubio.securecontrols.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xrubio.securecontrols.SecureButton;

public class MainJavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SecureButton secureButton = findViewById(R.id.secure_button);
        secureButton.setWindowObscuredTouchEvent((view, motionEvent) -> {
            Toast.makeText(this, "Screen overlay detected", Toast.LENGTH_LONG).show();
            return Boolean.FALSE;
        });
        secureButton.setOnClickListener(view -> {
            Toast.makeText(this, "Click succeeded!", Toast.LENGTH_LONG).show();
        });
    }
}
