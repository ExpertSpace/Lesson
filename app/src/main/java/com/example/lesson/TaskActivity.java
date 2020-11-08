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

    // для вывода результата (правильно/неправильно)
    TextView outRes;

    // для вывода очков
    TextView score;

    // для ввода результата
    EditText et_in;

    // для записи введеного результата
    String in = "";

    // две переменные, в которые программа рандомно записывает числа от -50 до 100
    int a, b;

    // для записи резултата операций a и b
    float c;

    // счетчик очков
    int scoreValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // инициализация View элементов
        out = (TextView) findViewById(R.id.output);
        outRes = (TextView) findViewById(R.id.outputRes);
        score = (TextView) findViewById(R.id.score);
        et_in = findViewById(R.id.et_input);
        score.setText("Score: " + scoreValue);

        // вызов функции для генерации значений переменных a и b, а также оператора (-, +, *, /)
        Generation();
    }

    public void Generation()
    {
        // инициализация a и b рандомным значением от -50 до 100
        a = -50 + (int)(Math.random() * 100);
        b = -50 + (int)(Math.random() * 100);

        // рандомно выбираем знак операции (-, +, *, /)
        int operation = (int)(Math.random() * 4);

        switch (operation)
        {
            // если 0, то оператор пусть будет +
            case 0:
                if(b < 0)
                    out.setText(a + "+(" + b + ")");
                else
                    out.setText(a + "+" + b);
                c = a + b;
                break;

            // если 1, то оператор пусть будет -
            case 1:
                if(b < 0)
                    out.setText(a + "-(" + b + ")");
                else
                    out.setText(a + "-" + b);
                c = a - b;
                break;

            // если 2, то оператор пусть будет *
            case 2:
                if(b < 0)
                    out.setText(a + "x(" + b + ")");
                else
                    out.setText(a + "x" + b);
                c = a * b;
                break;

            // если 3, то оператор пусть будет /
            case 3:
                if(b < 0)
                    out.setText(a + "/(" + b + ")");
                else
                    out.setText(a + "/" + b);
                c = (float) a / b;
                String str_f = String.format("%.3f", c);
                c = Float.parseFloat(str_f);
                break;
        }
    }

    // функция для проверки введенного и действительного результата
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

    // кнопка "Проверить"
    public void Check(View view)
    {
        String tempIn = et_in.getText().toString();
        in = String.format(tempIn, "%.3f");
        String d = in;

        if(in.isEmpty())
        {
            outRes.setTextColor(getResources().getColor(R.color.red));
            outRes.setText("Поле ввода ответа пустое!");
        }
        else
        {
            CheckAnswer();
            Generation();
            outRes.setText(d);
        }
    }
}