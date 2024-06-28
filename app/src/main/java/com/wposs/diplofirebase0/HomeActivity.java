package com.wposs.diplofirebase0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.wposs.diplofirebase0.MessageActivity.MessageActivity;
import com.wposs.diplofirebase0.SensorActivity.SensorActivity;

public class HomeActivity extends AppCompatActivity {
    private Button btnFirestore;
    private Button btnRealDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        btnFirestore = findViewById(R.id.buttonFirestore);
        btnRealDatabase = findViewById(R.id.buttonRealtimeDatabase);
        btnFirestore.setOnClickListener(v -> {
            // Ejemplo de redirección a otra actividad
            Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
            startActivity(intent);
            finish();
        });
        btnRealDatabase.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SensorActivity.class);
            startActivity(intent);
            finish();
        });
    }
}