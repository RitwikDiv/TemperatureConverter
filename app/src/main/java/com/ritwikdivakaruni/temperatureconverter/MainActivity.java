package com.ritwikdivakaruni.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radios;
    TextView getLabel;
    TextView printLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radios = findViewById(R.id.radioGroup);
        getLabel = findViewById(R.id.getLabel);
        printLabel = findViewById(R.id.printLabel);
        radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.ftoc: // TODO
                        getLabel.setText("Fahrenheit Degrees:");
                        printLabel.setText("Celsius Degrees:");
                        break;

                    case R.id.ctof:
                        getLabel.setText("Celsius Degrees:");
                        printLabel.setText("Fahrenheit Degrees:");
                        break;
                }
            }
        });
    }

}
