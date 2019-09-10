package com.example.realtimelocalization;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           loadLastLanguage();
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hindi:
                setLacalLanguage("hi");
                recreate();
                break;
            case R.id.mar:
                setLacalLanguage("mr");
                recreate();
                break;
            case R.id.eng:
                setLacalLanguage("en");
                recreate();
                break;
        }        return super.onOptionsItemSelected(item);
    }
    private void setLacalLanguage(String setlocallang) {
        //Declare and create Locale object call the string object
        Locale locale = new Locale(setlocallang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("Selected_Language",setlocallang);
        editor.apply();    }
    private void loadLastLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("Selected_Language","");
        setLacalLanguage(language);    }}
