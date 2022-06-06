package com.example.savingactivitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText addtext;
    TextView showText;
    CheckBox java,python,xml;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addtext=(EditText) findViewById(R.id.addtext);
        showText=(TextView)findViewById(R.id.showtext);
        java=(CheckBox)findViewById(R.id.java);
        python=(CheckBox)findViewById(R.id.python);
        xml=(CheckBox)findViewById(R.id.xml);
       btn=(Button)findViewById(R.id.btnok);
        SharedPreferences sharedPreferences=this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);

        java.setChecked(sharedPreferences.getBoolean("java",false));
        python.setChecked(sharedPreferences.getBoolean("python",false));
        xml.setChecked(sharedPreferences.getBoolean("xml",false));
        showText.setText(sharedPreferences.getString("text",""));



    }

    public void okbtn(View view) {
        SharedPreferences sharedPreferences=this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);

        sharedPreferences.edit().putBoolean("java",java.isChecked()).apply();
        sharedPreferences.edit().putBoolean("python",python.isChecked()).apply();
        sharedPreferences.edit().putBoolean("xml",xml.isChecked()).apply();

        showText.setText(addtext.getText().toString());

        sharedPreferences.edit().putString("text",showText.getText().toString()).apply();


    }
}
