package com.eslam.notestakersql_litedb;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    MyDataBaseHelper myDB;
    ArrayList<String> note_id_list, note_title_list, note_description_list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDataBaseHelper(MainActivity.this);
        note_id_list = new ArrayList<>();
        note_title_list = new ArrayList<>();
        note_description_list = new ArrayList<>();

        storeDataInArrays();

        adapter = new CustomAdapter(MainActivity.this, note_id_list, note_title_list, note_description_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);

    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data!!", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                note_id_list.add(cursor.getString(0));
                note_title_list.add(cursor.getString(1));
                note_description_list.add(cursor.getString(2));
            }
        }
    }
}