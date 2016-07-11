package com.shawn.br.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn.br.R;

/**
 * This is a single book fragment
 * Created by Three on 2016/7/11.
 */
public class BookInfoFragment extends Fragment {
    public BookInfoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_detail_layout,container,false);
        return view;
    }
}
