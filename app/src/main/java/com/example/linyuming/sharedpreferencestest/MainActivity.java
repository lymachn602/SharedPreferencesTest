package com.example.linyuming.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  private Button  save_data;
    private  Button put_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        put_data = (Button) findViewById(R.id.put_data);
        save_data = (Button) findViewById(R.id.save_data);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor  editor =  getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",20);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });
        put_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref  = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age = pref.getInt("age",0);
                boolean married =pref.getBoolean("married",false);
                Log.d("MainActivity","name is " + name);
                Log.d("MainActivity","age is " + age);
                Log.d("MainActivity","married is " + married);
            }
        });
    }
}
