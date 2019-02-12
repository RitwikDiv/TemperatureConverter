package com.ritwikdivakaruni.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radios;
    private TextView getLabel;
    private TextView printLabel;
    private TextView history;
    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.temperature);
        history = (TextView)findViewById(R.id.history);
        radios = findViewById(R.id.radioGroup);
        getLabel = findViewById(R.id.getLabel);
        printLabel = findViewById(R.id.printLabel);
        output = findViewById(R.id.result);
        history.setMovementMethod(ScrollingMovementMethod.getInstance());

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

        if(savedInstanceState != null){
            history.setText(savedInstanceState.getString("history"));
            output.setText(savedInstanceState.getString("result"));
        }

    }

    public void convertTemperature(View view){
            String inputValue = input.getText().toString();
            // To make sure that we don't compute anything if the string is empty
            if (inputValue.length() == 0){
                return;
            }
            input.setText("");
            String historyValue = history.getText().toString();
            float outputValue;

            if (radios.getCheckedRadioButtonId()== R.id.ftoc){
                float inputVal = Float.valueOf(inputValue).floatValue();
                outputValue = (float) ((inputVal - 32.0)*(5.0/9.0));
                output.setText(String.format("%.1f", outputValue));
                history.append(String.format(String.valueOf(inputVal)+" F => %.1f C \n", outputValue));
            }

            else{
                float inputVal = Float.valueOf(inputValue).floatValue();
                outputValue = (float) ((inputVal * (9.0/5.0)) + 32.0);
                output.setText(String.format("%.1f", outputValue));
                history.append(String.format(String.valueOf(inputVal)+" C => %.1f F \n", outputValue));
            }

    }
    public void clearHistory(View view){
        history.setText("");
        output.setText("");
        input.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle outSate){
        outSate.putString("history", history.getText().toString());
        outSate.putString("result", output.getText().toString());
        super.onSaveInstanceState(outSate);
    }

}
