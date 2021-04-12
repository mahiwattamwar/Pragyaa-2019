package org.maheshpragyaaa.pragyaa2021;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MobileActivity extends AppCompatActivity {

    private TextView number1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        String sessionId = getIntent().getStringExtra("mobile");
        number1 = findViewById(R.id.number1);
        number1.setText(sessionId);
    }
}