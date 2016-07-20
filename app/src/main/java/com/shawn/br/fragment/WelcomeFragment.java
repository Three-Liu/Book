package com.shawn.br.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        view.findViewById(R.id.register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .hide(getFragmentManager().findFragmentByTag(WelcomeFragment.class.getName()))
                        .add(R.id.container,new RegisterFragment(),RegisterFragment.class.getName())
                        .addToBackStack(WelcomeFragment.class.getName())
                        .commit();
            }
        });
        view.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .detach(getFragmentManager().findFragmentByTag(WelcomeFragment.class.getName()))
                        .add(R.id.container,new CenterFragment(),CenterFragment.class.getName())
                        .commit();
            }
        });
        return view;
    }
}
