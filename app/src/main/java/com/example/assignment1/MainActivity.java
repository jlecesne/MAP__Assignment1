package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Calculator c1 = new Calculator();

    //View for handling numbers and operation
    TextView operation;
    boolean flag=true;

    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button equals;
    Button clr;
    Button advance;
    Button mod;
    Button pow;
    Button max;
    Button min;
    LinearLayout scientific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets up on click listeners for all buttons
        setupListeners(savedInstanceState);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        //Gets id of any button clicked and adds a value to the TextView based on ID
        int id=view.getId();
        switch (id) {
            case R.id.btn0:
                operation.setText(operation.getText()+"0 ");
                break;

            case R.id.btn1:
                operation.setText(operation.getText()+"1 ");
                break;

            case R.id.btn2:
                operation.setText(operation.getText()+"2 ");
                break;

            case R.id.btn3:
                operation.setText(operation.getText()+"3 ");
                break;

            case R.id.btn4:
                operation.setText(operation.getText()+"4 ");
                break;

            case R.id.btn5:
                operation.setText(operation.getText()+"5 ");
                break;

            case R.id.btn6:
                operation.setText(operation.getText()+"6 ");
                break;

            case R.id.btn7:
                operation.setText(operation.getText()+"7 ");
                break;

            case R.id.btn8:
                operation.setText(operation.getText()+"8 ");
                break;

            case R.id.btn9:
                operation.setText(operation.getText()+"9 ");
                break;

            case R.id.btnPlus:
                operation.setText(operation.getText()+"+ ");
                break;

            case R.id.btnMinus:
                operation.setText(operation.getText()+"- ");
                break;

            case R.id.btnMultiply:
                operation.setText(operation.getText()+"* ");
                break;

            case R.id.btnDivide:
                operation.setText(operation.getText()+"/ ");
                break;

            case R.id.btnClr:
                operation.setText("");
                c1.total=-433;
                c1.calculation.clear();
                break;

            //Hides/Reveals scientific operands
            case R.id.btnAdvanced:
                if(flag) {
                    scientific.setVisibility(View.VISIBLE);
                    advance.setText("STANDARD");
                    flag=false;
                }
                else {
                    scientific.setVisibility(View.INVISIBLE);
                    advance.setText("ADVANCE - SCIENTIFIC");
                    flag=true;
                }

                break;

            case R.id.btnMod:
                operation.setText(operation.getText()+"% ");
                break;

            case R.id.btnPow:
                operation.setText(operation.getText()+"pow ");
                break;

            case R.id.btnMax:
                operation.setText(operation.getText()+"Max ");
                break;

            case R.id.btnMin:
                operation.setText(operation.getText()+"Min ");
                break;

            case R.id.btnEqual:

                //Pushes TextView items into an arraylist
                c1.push(operation.getText().toString());

                //Calculates result of ArrayList
                int value = c1.calculate();
                System.out.println(value + "hi");
                //-433 is the unique integer for an an error in the calculation whether that is an invalid operand or invalid number
                if(value==-433) {
                    operation.setText(operation.getText()+"Not an Operator");
                }
                else {
                    operation.setText(operation.getText()+"= "+c1.total+ " ");
                }
                break;
        }

        //Reset total
        c1.total = 0;


    }


    //Setups on click listeners for all buttons
    public void setupListeners(Bundle savedInstanceState) {

        num0=findViewById(R.id.btn0);
        num0.setOnClickListener(this);

        num1=findViewById(R.id.btn1);
        num1.setOnClickListener(this);

        num2=findViewById(R.id.btn2);
        num2.setOnClickListener(this);

        num3=findViewById(R.id.btn3);
        num3.setOnClickListener(this);

        num4=findViewById(R.id.btn4);
        num4.setOnClickListener(this);

        num5=findViewById(R.id.btn5);
        num5.setOnClickListener(this);

        num6=findViewById(R.id.btn6);
        num6.setOnClickListener(this);

        num7=findViewById(R.id.btn7);
        num7.setOnClickListener(this);

        num8=findViewById(R.id.btn8);
        num8.setOnClickListener(this);

        num9=findViewById(R.id.btn9);
        num9.setOnClickListener(this);

        plus=findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);

        minus=findViewById(R.id.btnMinus);
        minus.setOnClickListener(this);

        multiply=findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);

        divide=findViewById(R.id.btnDivide);
        divide.setOnClickListener(this);

        clr=findViewById(R.id.btnClr);
        clr.setOnClickListener(this);

        equals=findViewById(R.id.btnEqual);
        equals.setOnClickListener(this);

        advance=findViewById(R.id.btnAdvanced);
        advance.setOnClickListener(this);

        mod=findViewById(R.id.btnMod);
        mod.setOnClickListener(this);

        pow=findViewById(R.id.btnPow);
        pow.setOnClickListener(this);

        max=findViewById(R.id.btnMax);
        max.setOnClickListener(this);

        min=findViewById(R.id.btnMin);
        min.setOnClickListener(this);

        scientific =  findViewById(R.id.layoutScientific);
        operation = findViewById(R.id.calculation);
    }
}