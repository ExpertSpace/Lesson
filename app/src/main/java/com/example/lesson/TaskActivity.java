package com.example.lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    // для вывода значений переменных a и b
    TextView out;

    TextView outRes;
    TextView score;

    EditText et_in;

    String in = "";

    int a, b;
    float c;
    int scoreValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        out = (TextView) findViewById(R.id.output);
        outRes = (TextView) findViewById(R.id.outputRes);
        score = (TextView) findViewById(R.id.score);
        et_in = findViewById(R.id.et_input);
        score.setText("Score: " + scoreValue);

        Generation();
    }

    public void Generation()
    {
        a = -50 + (int)(Math.random() * 100);
        b = -50 + (int)(Math.random() * 100);

        int operation = (int)(Math.random() * 4);

        switch (operation)
        {
            case 0:
                if(b < 0)
                    out.setText(a + "+(" + b + ")");
                else
                    out.setText(a + "+" + b);
                c = a + b;
                break;

            case 1:
                if(b < 0)
                    out.setText(a + "-(" + b + ")");
                else
                    out.setText(a + "-" + b);
                c = a - b;
                break;

            case 2:
                if(b < 0)
                    out.setText(a + "x(" + b + ")");
                else
                    out.setText(a + "x" + b);
                c = a * b;
                break;

            case 3:
                if(b < 0)
                    out.setText(a + "/(" + b + ")");
                else
                    out.setText(a + "/" + b);
                c = (float) a / b;
                outRes.setText(""+c);
                break;
        }
    }

    public void CheckAnswer()
    {
        if(Float.parseFloat(in) == c)
        {
            outRes.setTextColor(getResources().getColor(R.color.green));
            outRes.setText("");
            outRes.setText("Правильно!");
            scoreValue++;
            score.setText("Score: " + scoreValue);
        }
        else
        {
            outRes.setTextColor(getResources().getColor(R.color.red));
            outRes.setText("");
            outRes.setText("Неправильно!");
        }

        in = "";
        ((EditText) findViewById(R.id.et_input)).setText("");
    }

    public void Check(View view)
    {
        in = et_in.getText().toString();
        if(in.isEmpty())
        {
            outRes.setTextColor(getResources().getColor(R.color.red));
            outRes.setText("Поле ввода ответа пустое!");
        }
        else
        {
            CheckAnswer();
            Generation();
        }
    }
}