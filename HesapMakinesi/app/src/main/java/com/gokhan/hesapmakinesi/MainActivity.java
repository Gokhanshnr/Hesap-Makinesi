package com.gokhan.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gokhan.hesapmakinesi.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    private ActivityMainBinding tasarimMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarimMain =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarimMain.getRoot());
    }

    

    public void buttonClicked(View v) {
        Button b = (Button) v;

        if(b.getText().toString().equals("AC")){
            deleteText();
        }else if(b.getText().toString().equals("=")){
            equalsText();
        }else{
            String a = b.getText().toString().trim();
            if(!(a.equals("(") || a.equals(")") || a.equals("÷") || a.equals("×") || a.equals("-") || a.equals(".")) ){
                editText(b.getText().toString().trim());
            }



        }
    }

    private void editText(String a){
        String s = tasarimMain.textView.getText().toString().trim();
        String result = (s.equals("0")) ? a : s+a;
        tasarimMain.textView.setText(result);
    }
    private void deleteText(){
        String s = tasarimMain.textView.getText().toString().trim();
        String result = s.length() > 0 ? s.substring(0, s.length() - 1) : s;
        tasarimMain.textView.setText(result);
    }
    private void equalsText(){
        String val = tasarimMain.textView.getText().toString().trim();
        String plus = val.replace('+','p');
        String[] hesap = plus.split("p");
        int sonHesap = 0;
        for(String s : hesap){
            sonHesap = sonHesap + Integer.parseInt(s);
        }
        tasarimMain.textView.setText(String.valueOf(sonHesap));
    }




}