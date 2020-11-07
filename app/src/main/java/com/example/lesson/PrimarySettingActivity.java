package com.example.lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class PrimarySettingActivity extends AppCompatActivity {
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_setting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        checkBox = (CheckBox) findViewById(R.id.nightMode);

        final Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.timer, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View itemSelected,
                                       int selectedItemPosition, long selectedId)
            {
                String[] choose = getResources().getStringArray(R.array.timer);
                Toast toast = Toast.makeText(getApplicationContext(),
                        choose[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 250);
                toast.show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void Start(View view) {
        Intent intent = new Intent(PrimarySettingActivity.this, TaskActivity.class);
        startActivity(intent);
    }
}