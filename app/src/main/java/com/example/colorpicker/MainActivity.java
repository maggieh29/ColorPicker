package com.example.colorpicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnMessageSendListener {

    FragmentManager fg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fg = getSupportFragmentManager();


        if (savedInstanceState == null) {
            fg.beginTransaction().replace(R.id.top, new ColorPickFragment()).commit();
            fg.beginTransaction().replace(R.id.bottom, new HistoryFragment()).commit();
        }
    }

    @Override
    public void onMessageSend(String message) {

        HistoryFragment listFragment = (HistoryFragment) fg.findFragmentById(R.id.bottom);

        if (listFragment != null) {
            listFragment.addColor(message);
        }

    }
}