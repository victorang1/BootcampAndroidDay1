package com.example.trainingandroidday1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trainingandroidday1.fragment.home.HomeFragment;
import com.example.trainingandroidday1.model.Person;
import com.example.trainingandroidday1.repository.TodoRepository;

public class InsertActivity extends AppCompatActivity {

    private EditText etPersonName, etPersonAge;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etPersonName.getText().toString();
                String age = etPersonAge.getText().toString();
                if(name.isEmpty() || name.equals("")) {
                    Toast.makeText(InsertActivity.this, "Name must be input", Toast.LENGTH_SHORT).show();
                }
                else if(age.isEmpty() || age.equals("")) {
                    Toast.makeText(InsertActivity.this, "Age must be input", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(InsertActivity.this, "Insert Success", Toast.LENGTH_SHORT).show();
                    TodoRepository.addPersonToList(new Person(name, age));
                    finish();
                }
            }
        });
    }
}
