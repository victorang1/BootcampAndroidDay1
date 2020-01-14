package com.example.trainingandroidday1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnMove, btnDisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        btnMove = findViewById(R.id.btnMove);
        btnDisplayName = findViewById(R.id.btnDisplayName);

        btnDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if(name == null || name.equals("")) {
                    Toast.makeText(MainActivity.this, "Name cannot empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Hello " + name, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if(name == null || name.equals("")) {
                    Toast.makeText(MainActivity.this, "Name cannot empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
