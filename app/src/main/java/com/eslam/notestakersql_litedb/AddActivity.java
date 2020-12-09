package com.eslam.notestakersql_litedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText et_title , et_description;
    Button add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_title = findViewById(R.id.title_et);
        et_description = findViewById(R.id.description_et);
        add_btn = findViewById(R.id.add_btn_addActivity);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDataBaseHelper myDB = new MyDataBaseHelper(AddActivity.this);
                myDB.addNote(et_title.getText().toString().trim() , et_description.getText().toString().trim());
            }
        });

    }
}