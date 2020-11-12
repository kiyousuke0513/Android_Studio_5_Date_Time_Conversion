package com.example.date_time_conversion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @SuppressLint("DefaultLocale")
    public void BTN_TRIG(View view) {
        EditText ET_Year = findViewById(R.id.editTextNumber_Year);
        EditText ET_Month = findViewById(R.id.editTextNumber_Month);
        EditText ET_Day = findViewById(R.id.editTextNumber_Day);
        EditText ET_Hour = findViewById(R.id.editTextNumber_Hour);
        EditText ET_Minute = findViewById(R.id.editTextNumber_Minute);
        EditText ET_Second = findViewById(R.id.editTextNumber_Second);
        TextView TV_Date = findViewById(R.id.textView_Date);
        TextView TV_Time = findViewById(R.id.textView_Time);
        TextView TV_LeapYear = findViewById(R.id.textView_LeapYear);
        int Year;
        int Month;
        int Day;
        int Hour;
        int Minute;
        int Second;
        String Date;
        String Time;

        // 取得鍵盤管理物件
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        // 隱藏指定 view 的虛擬鍵盤
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        if(!String.valueOf(ET_Year.getText()).equals(""))
            Year = Integer.parseInt(String.valueOf(ET_Year.getText()));
        else
            ET_Year.setText(String.valueOf(Year = 2020));
        if(!String.valueOf(ET_Month.getText()).equals(""))
            Month = Integer.parseInt(String.valueOf(ET_Month.getText()));
        else
            ET_Month.setText(String.valueOf(Month = 1));
        if(!String.valueOf(ET_Day.getText()).equals(""))
            Day = Integer.parseInt(String.valueOf(ET_Day.getText()));
        else
            ET_Day.setText(String.valueOf(Day = 1));

        Date = String.format("%04d",Year) + "/" + String.format("%02d",Month) + "/" + String.format("%02d",Day);
        TV_Date.setText(Date);


        if(!String.valueOf(ET_Hour.getText()).equals(""))
            Hour = Integer.parseInt(String.valueOf(ET_Hour.getText()));
        else
            ET_Hour.setText(String.valueOf(Hour = 0));
        if(!String.valueOf(ET_Minute.getText()).equals(""))
            Minute = Integer.parseInt(String.valueOf(ET_Minute.getText()));
        else
            ET_Minute.setText(String.valueOf(Minute = 0));
        if(!String.valueOf(ET_Second.getText()).equals(""))
            Second = Integer.parseInt(String.valueOf(ET_Second.getText()));
        else
            ET_Second.setText(String.valueOf(Second = 0));

        Time = String.format("%02d",Hour) + ":" + String.format("%02d",Minute) + ":" + String.format("%02d",Second);
        TV_Time.setText(Time);

        if(Year % 4 == 0)
        {
            if (Year % 100 == 0)
            {
                if (Year % 400 == 0)
                    TV_LeapYear.setText(R.string.LeapYear_Yes);
                else
                    TV_LeapYear.setText(R.string.LeapYear_No);
            }
            else
                TV_LeapYear.setText(R.string.LeapYear_Yes);
        }
        else
            TV_LeapYear.setText(R.string.LeapYear_No);
    }
}