package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Calculator c1;
    TextView operation;

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

    ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons.set(0, findViewById(R.id.btn1));
        buttons.get(0).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id == R.id.btn1) {
            Toast.makeText(getApplicationContext(), "Click",Toast.LENGTH_SHORT).show();
        }

    }
}