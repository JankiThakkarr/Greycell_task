package com.example.greycell_task;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country = {"0", "1", "2", "3", "4", "5"};
    int index = 0;
    AppCompatButton button;
    TextView tvInputText;
    TextView tvOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        tvInputText = (TextView) findViewById(R.id.tvInputText);
        tvOutputText = (TextView) findViewById(R.id.tvOutputText);
        button = (AppCompatButton) findViewById(R.id.btnRun);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        index = Integer.parseInt(country[position]) + 1;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                String[] temp = tvInputText.getText().toString().split("\\.");
                for (int i = 0; i < temp.length; i++) {
                    //System.out.println(i);
                    result = result + "." + reverseWords(tvInputText.getText().toString().split("\\.")[i]);
                }
                tvOutputText.setText(result);
                System.out.println(result);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    String reverseWords(String str) {
        String[] arrStr = str.split(" ");
        String result = "";
        if (index == 0) {
            result = str;
        } else {
            for (int i = 0; i < arrStr.length / index; i++) {
                String temp = arrStr[i];
                arrStr[i] = arrStr[arrStr.length - i - index];
                arrStr[arrStr.length - i - index] = temp;
            }

            for (int i = 0; i < arrStr.length; i++) {
                result = result + " " + arrStr[i];
                System.out.print(arrStr[i] + " ");
            }
        }
        return result;
    }
}
