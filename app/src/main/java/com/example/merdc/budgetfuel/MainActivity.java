package com.example.merdc.budgetfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mGasText;
    EditText mAlcoholText;
    TextView mResultText;
    Button mCalcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGasText = (EditText) findViewById(R.id.gasText);
        mAlcoholText = (EditText) findViewById(R.id.alcoholText);
        mResultText = (TextView) findViewById(R.id.resultTxt);

        mCalcBtn = (Button) findViewById(R.id.calcButton);

        mCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mResultText.setText(getString(R.string.resultText));

                if (!mGasText.getText().toString().isEmpty() && !mAlcoholText.getText().toString().isEmpty()) {
                    float gas = Float.parseFloat(mGasText.getText().toString());
                    float alcohol = Float.parseFloat(mAlcoholText.getText().toString());

                    if (alcohol / gas <= 0.7) {
                        mResultText.setText(getString(R.string.resultText) + " " + "Alcohol");
                    } else {
                        mResultText.setText(getString(R.string.resultText) + " " + "Gas");
                    }
                }
            }
        });
    }
}
