package com.example.practiceapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceScreen extends AppCompatActivity {

    EditText editText = findViewById(R.id.editText);
    Button AddButton = findViewById(R.id.AddButton);
    GridView gridView1 = findViewById(R.id.gridView1);

    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preference_screen);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        dataList = new ArrayList<>();
        loadData();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        gridView1.setAdapter(adapter);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputData = editText.getText().toString().trim();
                if(!inputData.isEmpty()){
                    dataList.add(inputData);
                    saveData();
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveData(){

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Set<String> dataSet = new HashSet<>(dataList);
        editor.putStringSet("dataList", dataSet);
        editor.apply();


        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    private void loadData(){

        Set<String> dataSet = sharedPreferences.getStringSet("dataList", new HashSet<>());

        dataList.clear();
        dataList.addAll(dataSet);

    }
}