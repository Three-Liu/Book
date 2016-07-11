package com.shawn.br;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * This Activity:
 * 1> split into two fragment
 * 2> pivot of this program
 */
public class CenterActivity extends AppCompatActivity {
    private SearchView searchView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_center);
        searchView = (SearchView) findViewById(R.id.search);
        textView = (TextView) findViewById(R.id.test);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // get query from here and execDB
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }

        });
    }
}
