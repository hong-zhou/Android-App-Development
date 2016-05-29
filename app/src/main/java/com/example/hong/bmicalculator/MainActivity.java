package com.example.hong.bmicalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MainActivity extends Activity {

    Button btnCalculate;
    EditText etAge;
    EditText etHeight;
    EditText etWeight;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        textView = (TextView) findViewById(R.id.textView);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weightTemp = 0.0;
                double heightTemp = 0.0;
                String temp = (etAge.getText().toString());
                if(temp == "")
                {
                    textView.setText("Enter Age");
                }
                else {
                    try{double ageTemp = Double.parseDouble(etAge.getText().toString());}
                    catch(NumberFormatException exception){
                        etAge.setHint("MUST Enter AGE!");
                    }
                    try{weightTemp = Double.parseDouble(etWeight.getText().toString());}
                    catch(NumberFormatException e){
                        etWeight.setHint("MUST ENTER WEIGHT!");
                    }
                    try{heightTemp = Double.parseDouble(etHeight.getText().toString());}
                    catch(NumberFormatException e){
                        etHeight.setHint("MUST ENTER HEIGHT!");
                    }
                    double height = heightTemp * heightTemp;

                    double BMI = (weightTemp / height) * 703.0;
                    textView.setText(String.format("%.2f", BMI));

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
