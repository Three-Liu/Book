package com.shawn.br;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.shawn.br.fragment.WelcomeFragment;

/**
 * In this activity,
 * 1> Confirm and Register(new user) Confirm (old user)
 * 2> get client info (nickname, gender)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new WelcomeFragment(),WelcomeFragment.class.getName())
                .commit();
    }
}
