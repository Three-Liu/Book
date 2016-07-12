package com.shawn.br;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.shawn.br.fragment.QuaryFragment;

/**
 * This Activity:
 * 1> split into two fragment
 * 2> pivot of this program
 */
public class CenterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_center);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.center_container,new QuaryFragment(),QuaryFragment.class.getName())
                .commit();
    }
}
