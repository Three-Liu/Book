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
        View view = inflater.inflate(R.layout.fragment_wechat,container,false);
        view.findViewById(R.id.first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .detach(getFragmentManager().findFragmentByTag(WelcomeFragment.class.getName()))
                        .add(R.id.container_welcome,new MajorGradeFragment())
                        .commit();
            }
        });
        view.findViewById(R.id.old).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CenterActivity.class));
                getActivity().finish();
            }
        });
        view.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;
    }
}
