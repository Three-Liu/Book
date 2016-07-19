package com.shawn.br.fragment.confirm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn.br.CenterActivity;
import com.shawn.br.R;

/**
 * Build a fragement to simulate Wechat ConFirm
 * Created by Three on 2016/7/11.
 */
public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome,container,false);
        return view;
    }
}
