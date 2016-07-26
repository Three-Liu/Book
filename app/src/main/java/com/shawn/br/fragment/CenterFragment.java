package com.shawn.br.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shawn.br.R;

/**
 * This fragment is the center fragment
 *  switch from me and book_logo
 * Created by Three on 2016/7/20.
 */
public class CenterFragment extends Fragment {
    public CenterFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_center,container,false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolBar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setLogo(getResources().getDrawable(R.drawable.book_logo,null));
        toolbar.setTitle(" Read And Share");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getTitle().equals("Exit")){
                    getActivity().finish();
                }
                return false;
            }
        });
        view.findViewById(R.id.center_book).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container,new BookFragment())
//                        .commit();
            }
        });
        return view;
    }
}
