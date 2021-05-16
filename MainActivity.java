package com.example.android.may;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText  mBuytx, mSelltx, mQuantitytx;
    TextView mTaxtx, mAnswer, mLoss;
    Button mCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBuytx = (EditText) findViewById(R.id.Buytx);
        mSelltx = (EditText) findViewById(R.id.Selltx);
        mQuantitytx = (EditText) findViewById(R.id.Quantitytx);

        mTaxtx = (TextView) findViewById(R.id.Taxtx);
        mAnswer = (TextView) findViewById(R.id.Answer);
        mLoss = (TextView) findViewById(R.id.Loss);

         mCalculate = (Button) findViewById(R.id.Calculate);

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double fBuy =  Float.parseFloat(mBuytx.getText().toString());
                double fSell =  Float.parseFloat(mSelltx.getText().toString());
                double fQuantity = Float.parseFloat(mQuantitytx.getText().toString());

                double sum = fBuy + fSell;

                double diff = fSell - fBuy;
                double PL = diff * fQuantity;

                double fSTT = (sum * fQuantity* 1 )/1000;
                double Exchange = (sum * 69)/2000000;
                double GST = (Exchange * 18)/100;
                double stamp = (fBuy * 3)/20000;

                double total_tax = GST + fSTT + Exchange + stamp;

                double fAnswer = PL - total_tax;

                mTaxtx.setText(new DecimalFormat("##.##").format(total_tax));




               // mTaxtx.setText(String.valueOf(total_tax));
                String a = String.format("%.2f", fAnswer);


                if (fAnswer >= 0) {

                    mAnswer.setText(String.valueOf("Profit = " + a));
                }
                else{
                    mLoss.setText(String.valueOf("Loss =  " + a));
                }





            }
        });


    }

}